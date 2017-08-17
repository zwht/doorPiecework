package com.zw.cf.controller;

import com.wordnik.swagger.annotations.*;
import com.zw.cf.dao.UserMapper;
import com.zw.cf.model.User;
import com.zw.cf.service.UserService;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;
import java.util.List;
import java.util.Observable;


/**
 * Created by zhaowei on 2017/6/24.
 */
@Api("user")
@Controller("userAction")
@Scope("prototype")
@RequestMapping("/rest/user")

public class UserCtrl {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加用户")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品信息"),
            @ApiResponse(code = 201, message = "(token验证失败)", response = String.class),
            @ApiResponse(code = 202, message = "(系统错误)", response = String.class)})

    public Response add(
            @ApiParam(required = true, value = "用户名", name = "userName") @RequestParam String userName,
            @ApiParam(required = true, value = "密码", name = "passWord") @RequestParam String passWord
    ) {
        Date date = new Date();
        //使用用户名查询是否有相同用户名
        User user = userMapper.selectByUserName(userName);

        if (user == null) {
            user = new User();
            user.setId(date.getTime()+"");
            user.setUsername(userName);
            user.setPassword(passWord);
            int id = userMapper.insert(user);
            return new Response().success("添加成功" + id);
        } else {
            return new Response().failure(400, "已经有此用户名！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有用户列表", httpMethod = "GET", notes = "获取用户", consumes = "application/json")
    public Response<List<User>> getUserList() {
        List<User> list = userMapper.selectByExample(null);
        return new Response().success(list);
    }


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口", httpMethod = "POST", notes = "登录")
    public Response<User> login(
            @ApiParam(required = true, value = "用户名", name = "userName") @RequestParam String userName,
            @ApiParam(required = true, value = "密码", name = "passWord") @RequestParam String passWord
    ) {
        return userService.login(userName,passWord);
    }


    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户userId获取用户信息", httpMethod = "GET", notes = "获取用户")
    public Response<User> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id", name = "userId") @RequestParam String userId
    ) {
        return userService.getUserById(userId);
    }
}
