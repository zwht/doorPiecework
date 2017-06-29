package com.zw.cf.dao;

import com.zw.cf.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zhaowei on 2017/6/24.
 */
@Repository("userDao")
public class UserDao implements UserDaoInterface {

    @Resource
    private JdbcTemplate jdbcTemplate;


    public void add(User user){

        String sql="insert into users(id,userName,passWord) values(?,?,?)";
        if(user!=null){
            jdbcTemplate.update(sql,user.getId(),user.getUserName(),user.getPassWord());
            System.out.println("fuck");
        }else{
            throw new NullPointerException();
        }
    }

    public void delete(String id){
        System.out.println("delete："+id);
    }

    public User load(String id){
        System.out.println("load："+id);

        return null;
    }

}
