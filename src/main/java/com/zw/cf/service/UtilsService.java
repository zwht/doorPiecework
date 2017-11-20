package com.zw.cf.service;

import com.zw.cf.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface UtilsService {
    User getUser(HttpServletRequest request);

}
