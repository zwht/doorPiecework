package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.UserMapper;
import com.zw.cf.model.User;
import com.zw.cf.service.UserService;
import com.zw.plug.PageObj;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * Created by zhaowei on 2017/8/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public Response getUserById(String id) {
        Response response = new Response();
        try {
            return response.success(userMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response getUserByName(String name) {
        Response response = new Response();
        try {
            return response.success(userMapper.selectByUserName(name));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    public Response login(String userName, String passWord) {
        Response<User> response = new Response();
        try {
            if (userName == null || userName == "") {
                throw new Exception("用户名不能为空!");
            }
            if (passWord == null || passWord == "") {
                throw new Exception("密码不能为空!");
            }

            User user = userMapper.selectByUserName(userName);

            if(user == null){
                return response.failure(400, "用户名不存在！");
            }else if (user.getPassword().equals(passWord)) {
                return response.success(user);
            } else {
                return response.failure(400, "密码错误！");
            }

        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }


    }

    public Response getUserList(Integer pageNum, Integer pageSize) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = userMapper.selectByExample(null);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    public Response addUser(String userName, String passWord) {
        Response response = new Response();
        try {
            Date date = new Date();
            //使用用户名查询是否有相同用户名
            User user = userMapper.selectByUserName(userName);

            if (user == null) {
                User newUser=new User();
                newUser.setId(date.getTime() + "");
                newUser.setUsername(userName);
                newUser.setPassword(passWord);

                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<User>> constraintViolations= validator.validate(newUser);

                if(constraintViolations.size()!=0){
                    return response.validation(constraintViolations);
                }else {
                    userMapper.insert(newUser);
                    return response.success("添加成功");
                }

            } else {
                return response.failure(400, "已经有此用户名！");
            }
        } catch (Exception e) {
            return response.failure(400, "未知错误！");
        }
    }
}
