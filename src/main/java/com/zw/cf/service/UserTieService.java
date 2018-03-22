package com.zw.cf.service;

import com.zw.cf.model.UserTie;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface UserTieService {
    Response add(UserTie userTie);
    Response getById(String id);
    Response update(UserTie userTie);
    Response del(String id);
}
