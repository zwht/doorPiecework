package com.zw.cf.service.impl;
import com.zw.cf.model.User;
import com.zw.cf.service.UtilsService;
import com.zw.plug.JwtUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * Created by zhaowei on 2017/8/17.
 */
@Service
public class UtilsServiceImplImpl implements UtilsService {

    public User getUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            token = request.getParameter("Authorization");
        }
        User user = JwtUtils.unsign(token, User.class);
        return user;
    }
}
