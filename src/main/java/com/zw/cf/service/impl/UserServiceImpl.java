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

import java.util.List;

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

            response = this.getUserByName(userName);

            User user = response.getData();
            if (user != null && user.getPassword().equals(passWord)) {
                return new Response().success(response);
            } else {
                return new Response().failure(400, "用户名密码错误！");
            }

        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }


    }

    public Response getUserList (Integer pageNum,Integer pageSize){
        Response response=new Response();
        PageObj pageObj=new PageObj();
        try {
            Page page=PageHelper.startPage(pageNum, pageSize);
            List list = userMapper.selectByExample(null);
            long count = page.getTotal();
            return response.success(pageObj.init(pageNum,pageSize,count,list));
        }catch (Exception e){
            return response.failure(400, e.getMessage());
        }
    }

}
