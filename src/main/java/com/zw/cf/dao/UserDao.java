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


    public String add(User user){

        String sql="insert into users(id,userName,passWord) values(?,?,?)";
        if(user!=null){
            jdbcTemplate.update(sql,user.getId(),user.getUserName(),user.getPassWord());
            return "add";
        }else{
            return "error";
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

    public List<User> getUserList(){
        String sql = "select * from users";

        List<User> userList1 = jdbcTemplate.query(sql,
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int i) throws SQLException {
                        User user1 = new User();
                        user1.setId(rs.getString("id"));
                        user1.setUserName(rs.getString("username"));
                        user1.setPassWord(rs.getString("password"));
                        return user1;
                    }
                });

        return userList1;
    }

}
