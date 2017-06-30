package com.zw.cf.controller;

import com.zw.cf.model.User;
import com.zw.cf.service.UserServiceInterface;
import com.zw.plug.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    private User user;
    private UserServiceInterface UserService;
    private String id;
    private List<String> names;

    @Resource
    public void setUserService(UserServiceInterface UserService){
        this.UserService=UserService;
    }
    //@Resource
    public void setUser(User user){
        this.user=user;
    }

    @RequestMapping("/add")
    public String add(){
        //Date date=new Date();
        //user=new User(date.toString(),"name3333","pppppp");
        //UserService.add(user);
        return "app";
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET,consumes = "application/json")
    public @ResponseBody Response getId(HttpServletRequest request, HttpServletResponse response, User user){

        return new Response().success(new User("000","name3333","pppppp"));
    }
    public void delete(){
        UserService.delete(id);
    }
    public void load(){
        UserService.load(id);
    }
}
