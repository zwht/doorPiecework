package com.zw.cf.action;

import com.zw.cf.model.User;
import com.zw.cf.service.UserServiceInterface;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zhaowei on 2017/6/24.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction {
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

    public void add(){
        UserService.add(user);
    }
    public void delete(){
        UserService.delete(id);
    }
    public void load(){
        UserService.load(id);
    }
}
