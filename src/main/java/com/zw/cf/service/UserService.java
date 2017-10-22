package com.zw.cf.service;

import com.zw.cf.vo.UserListFind;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface UserService {
    Response getUserById(String id);
    Response login(String name,String passWord);
    Response refreshToken(String token,String token1);
    Response getUserList(Integer pageNum, Integer pageSize, UserListFind userListFind);
    Response addUser(String name,String passWord);

}
