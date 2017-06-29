package com.zw.cf.controller;

import com.zw.cf.model.User;
import com.zw.cf.service.UserServiceInterface;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zhaowei on 2017/6/24.
 */
@Controller("userAction")
@Scope("prototype")
@RequestMapping("/user")
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
    public void add(){
        user=new User("id999","name3333","pppppp");
        UserService.add(user);
        //return "app";
    }
    public void delete(){
        UserService.delete(id);
    }
    public void load(){
        UserService.load(id);
    }
}
