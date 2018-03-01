package com.zw.cf.service;

import com.zw.cf.model.User;
import com.zw.cf.vo.ResetPasswordVo;
import com.zw.cf.vo.UserListFind;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface UserService {
    Response getUserById(String id);
    Response login(String name,String password);
    Response refreshToken(String token,String token1);
    Response getUserList(Integer pageNum, Integer pageSize, UserListFind userListFind);
    Response addUser(User user);
    Response update(User user);
    Response del(String id);
    Response resetPassword(ResetPasswordVo resetPasswordVo);

}
