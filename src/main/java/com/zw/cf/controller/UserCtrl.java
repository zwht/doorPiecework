package com.zw.cf.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.zw.cf.dao.UserMapper;
import com.zw.cf.model.UserExample;
import com.zw.cf.model.User;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    @RequestMapping(value = "/getUserList", method = RequestMethod.GET,consumes = "application/json")
    public @ResponseBody List<User> getUserList(HttpServletRequest request, HttpServletResponse response){

        UserExample user1Example=null;
        return userMapper.selectByExample(user1Example);
    }

    /**登录接口**/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Response login(HttpServletRequest request, HttpServletResponse response){

        String username=request.getParameter("userName");
        String password=request.getParameter("passWord");

        User user=userMapper.selectByUserName(username);


        if(user.getPassword().equals(password)){
            return new Response().success(user);
        }else {
            return new Response().failure("用户名密码错误！");
        }
    }



    @RequestMapping(value = "/getUser", method = RequestMethod.GET,consumes = "application/json")
    public  @ResponseBody Response selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response){
        String userId=request.getParameter("userId");
        User user1=userMapper.selectByPrimaryKey(userId);
        return new Response().success(user1);
    }
}
