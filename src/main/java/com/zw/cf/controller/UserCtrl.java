package com.zw.cf.controller;

import com.wordnik.swagger.annotations.*;
import com.zw.cf.dao.UserMapper;
import com.zw.cf.model.UserExample;
import com.zw.cf.model.User;
import com.zw.plug.Response;
import com.zw.plug.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;
import java.util.List;


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



    @ResponseBody
    @RequestMapping(value = "/add")
    @ApiOperation(value="添加用户",httpMethod="POST",notes="添加用户")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品信息"),
        @ApiResponse(code = 201, message = "(token验证失败)",  response=String.class),
        @ApiResponse(code = 202, message = "(系统错误)",response = String.class)})

    public Response add(
            @ApiParam(required=true,value="用户名",name="userName") @RequestParam String userName,
            @ApiParam(required=true,value="密码",name="passWord") @RequestParam String passWord
    ){
        Date date=new Date();
        //使用用户名查询是否有相同用户名
        User user=userMapper.selectByUserName(userName);

        if(user==null){
            user=new User();
            user.setId(date.toString());
            user.setUsername(userName);
            user.setPassword(passWord);
            int id=userMapper.insert(user);
            return new Response().success("添加成功"+id);
        }else {

            return new Response().failure("已经有此用户名！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getUserList", consumes = "application/json")
    @ApiOperation(value="获取所有用户列表",httpMethod="GET",notes="获取用户")
    public  List<User> getUserList(){

        UserExample user1Example=null;
        return userMapper.selectByExample(user1Example);
    }


    @ResponseBody
    @RequestMapping(value = "/login")
    @ApiOperation(value="登录接口",httpMethod="POST",notes="登录")
    public  Response login(
            @ApiParam(required=true,value="用户名",name="userName") @RequestParam String userName,
            @ApiParam(required=true,value="密码",name="passWord") @RequestParam String passWord
    ){
        User user=userMapper.selectByUserName(userName);
        if(user.getPassword().equals(passWord)){
            return new Response().success(user);
        }else {
            return new Response().failure("用户名密码错误！");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/getUser")
    @ApiOperation(value="根据用户userId获取用户信息",httpMethod="GET",notes="获取用户")
    public Result<User> selectByPrimaryKey(
            @ApiParam(required=true,value="用户Id",name="userId") @RequestParam String userId
    ){
        User user1=userMapper.selectByPrimaryKey(userId);
        Result result = new Result();
        result.setValue(user1);
        return result;
    }
}
