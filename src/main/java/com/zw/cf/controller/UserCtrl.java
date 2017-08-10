package com.zw.cf.controller;

import com.zw.cf.dao.User1Mapper;
import com.zw.cf.model.User1Example;
import com.zw.cf.model.User1;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


/**
 * Created by zhaowei on 2017/6/24.
 */
@Controller("userAction")
@Scope("prototype")
@RequestMapping("/rest/user")
public class UserCtrl {
    @Autowired
    User1Mapper user1Mapper;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody Response add(HttpServletRequest request){
        Date date=new Date();
        String username=request.getParameter("userName");
        String password=request.getParameter("passWord");
        User1 user=user1Mapper.selectByUserName(username);
        System.out.println("==============="+user);
        System.out.println(user==null);
        if(user==null){
            user=new User1();
            user.setId(date.toString());
            user.setUsername(username);
            user.setPassword(password);
            int id=user1Mapper.insert(user);
            return new Response().success("添加成功"+id);
        }else {

            return new Response().failure("已经有此用户名！");
        }
    }


    @RequestMapping(value = "/getUserList", method = RequestMethod.GET,consumes = "application/json")
    public @ResponseBody List<User1> getUserList(HttpServletRequest request, HttpServletResponse response){

        User1Example user1Example=null;
        return user1Mapper.selectByExample(user1Example);
    }

    /**登录接口**/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Response login(HttpServletRequest request, HttpServletResponse response){

        String username=request.getParameter("userName");
        String password=request.getParameter("passWord");

        User1 user=user1Mapper.selectByUserName(username);


        if(user.getPassword().equals(password)){
            return new Response().success(user);
        }else {
            return new Response().failure("用户名密码错误！");
        }
    }



    @RequestMapping(value = "/getUser", method = RequestMethod.GET,consumes = "application/json")
    public  @ResponseBody Response selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response){
        String userId=request.getParameter("userId");
        User1 user1=user1Mapper.selectByPrimaryKey(userId);
        return new Response().success(user1);
    }
}
