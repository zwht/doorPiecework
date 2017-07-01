package com.zw.cf.dao;



import com.zw.cf.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


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

    public User getUserByName(String userName){

        String sql = "select * from users where userName = ?";
        /*User  user = jdbcTemplate.queryForObject(sql, User.class, userName);*/

        User user=null;

        List<User> userList = jdbcTemplate.query(sql, new Object[]{userName},
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setUserName(rs.getString("username"));
                        user.setPassWord(rs.getString("password"));
                        return user;
                    }
                });

        if(null!=userList&&userList.size()>0){
            user = userList.get(0);
        }
        return user;

    }

}
