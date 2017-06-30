package com.zw.cf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaowei on 2017/6/30.
 */
@Controller
@RequestMapping("/")
public class PageRouterCtrl {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
