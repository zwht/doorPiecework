package com.zw.cf.service;

import com.zw.cf.dao.UserDaoInterface;
import com.zw.cf.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhaowei on 2017/6/24.
 */
@Service("userService")
public class UserService implements UserServiceInterface {
    private UserDaoInterface userDao;

    public UserDaoInterface getUserDao(){
        return userDao;
    }
    @Resource
    public void setUserDao(UserDaoInterface userDao){
        this.userDao=userDao;
    }

    public void add(User user){
        userDao.add(user);
    }
    public void delete(String id){
        userDao.delete(id);
    }
    public User load(String id){
        return  userDao.load(id);
    }
}
