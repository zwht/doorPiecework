package com.zw.cf.dao;

import com.zw.cf.model.User;

/**
 * Created by zhaowei on 2017/6/24.
 */
public interface UserDaoInterface {
    public void add(User user);
    public void delete(String id);
    public User load(String id);
}
