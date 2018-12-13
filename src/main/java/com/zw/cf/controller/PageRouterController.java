package com.zw.cf.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaowei on 2017/6/30.
 */
@Api(value = "／", description = "首页路由配置", hidden = true)
@Controller
@RequestMapping("/")

/* */
public class PageRouterController {
    @RequestMapping("/")
    public String index(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        return "frontend/index";
    }
}
