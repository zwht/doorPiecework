package com.zw.cf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaowei on 2017/6/30.
 */
@Controller
@RequestMapping("/")

/* */
public class PageRouterCtrl {
    @RequestMapping("/")
    public String index(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        return "login";
    }
}
