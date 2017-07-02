package com.zw.cf.controller;

import com.zw.cf.model.User;
import com.zw.cf.service.UserServiceInterface;
import com.zw.plug.Response;
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

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody Response add(HttpServletRequest request){
        Date date=new Date();
        String username=request.getParameter("userName");
        String password=request.getParameter("passWord");
        User user=UserService.getUserByName(username);
        System.out.println("==============="+user);
        System.out.println(user==null);
        if(user==null){
            user=new User(date.toString(),username,password);
            UserService.add(user);
            return new Response().success("添加成功");
        }else {

            return new Response().failure("已经有此用户名！");
        }
    }






    @RequestMapping(value = "/get", method = RequestMethod.GET,consumes = "application/json")
    public @ResponseBody Response getId(HttpServletRequest request, HttpServletResponse response, User user){

        return new Response().success(new User("000","name3333","pppppp"));
    }

    /**登录接口**/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Response login(HttpServletRequest request, HttpServletResponse response){

        String username=request.getParameter("userName");
        String password=request.getParameter("passWord");

        User user=UserService.getUserByName(username);

        System.out.println(user.getPassWord().equals(password));
        System.out.println("user is:"+user.getPassWord());

        if(user.getPassWord().equals(password)){
            return new Response().success(user);
        }else {
            return new Response().failure("用户名密码错误！");
        }
    }

    public void delete(){
        UserService.delete(id);
    }
}
