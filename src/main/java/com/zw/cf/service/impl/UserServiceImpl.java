package com.zw.cf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.cf.dao.UserMapper;
import com.zw.cf.model.User;
import com.zw.cf.model.UserExample;
import com.zw.cf.service.UserService;
import com.zw.cf.vo.UserListFind;
import com.zw.plug.JwtUtils;
import com.zw.plug.PageObj;
import com.zw.plug.Response;
import com.zw.plug.ZwUtil;
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

    public Response login(String name, String password) {
        Response<User> response = new Response();
        try {
            if (name == null || name == "") {
                throw new Exception("用户名不能为空!");
            }
            if (password == null || password == "") {
                throw new Exception("密码不能为空!");
            }
            UserExample userExample=new UserExample();
            UserExample.Criteria criteria=userExample.createCriteria();
            criteria.andUsernameEqualTo(name);
            //使用用户名查询是否有相同用户名
            List<User> users = userMapper.selectByExample(userExample);


            ZwUtil zwUtil=new ZwUtil();
            if(users.size() == 0){
                return response.failure(400, "用户名不存在！");
            }else if (users.get(0).getPassword().equals(zwUtil.EncoderByMd5(password))) {
                User userOne=users.get(0);
                long currentTime = System.currentTimeMillis();
                currentTime +=2*60*60*1000;
                Date date = new Date(currentTime);
                    userOne.setTokentime(date);
                userOne.setPassword("");

                String token = JwtUtils.sign(users.get(0), 30L * 24L * 3600L * 1000L);
                userOne.setToken(token);
                return response.success(userOne);
            } else {
                return response.failure(400, "密码错误！");
            }

        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }


    }

    public Response refreshToken(String token,String token1) {
        Response<User> response = new Response();
        if(!token.equals(token1)) return response.failure(400,"请求错误，token不同！");
        try {
            User user = JwtUtils.unsign(token, User.class);
            Date newDate = new Date();
            Date date = user.getTokentime();
            if (newDate.getTime() < date.getTime()) {
                return response.failure(400, "token过期");
            }
            //使用用户名查询是否有相同用户名
            long currentTime = System.currentTimeMillis();
            currentTime += 2 * 60 * 60 * 1000;
            Date date1 = new Date(currentTime);
            user.setTokentime(date1);

            String newToken = JwtUtils.sign(user, 30L * 24L * 3600L * 1000L);
            user.setToken(newToken);
            return response.success(user);
        }catch (Exception e){
            return response.failure(400, e.getMessage());
        }
    }

    public Response getUserList(Integer pageNum, Integer pageSize, UserListFind userListFind) {
        Response response = new Response();
        PageObj pageObj = new PageObj();
        //条件查询3句话
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andCorporationidEqualTo(userListFind.getCorporationId());
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = userMapper.selectByExample(example);
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
            UserExample userExample=new UserExample();
            UserExample.Criteria criteria=userExample.createCriteria();
            criteria.andUsernameEqualTo(userName);
            //使用用户名查询是否有相同用户名
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size() == 0) {
                ZwUtil zwUtil=new ZwUtil();
                User newUser=new User();
                newUser.setId(date.getTime() + "");
                newUser.setUsername(userName);
                newUser.setPassword(zwUtil.EncoderByMd5(passWord));

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
