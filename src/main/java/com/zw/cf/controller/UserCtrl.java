package com.zw.cf.controller;

import com.wordnik.swagger.annotations.*;
import com.zw.cf.model.User;
import com.zw.cf.service.UserService;
import com.zw.cf.vo.LoginVo;
import com.zw.cf.vo.UserListFind;
import com.zw.plug.JwtUtils;
import com.zw.plug.PageObj;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by zhaowei on 2017/6/24.
 */
@Api("user")
@Controller("userAction")
@Scope("prototype")
@RequestMapping("/cfmy/user")

public class UserCtrl {
    @Autowired
    UserService userService;


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加用户")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品信息"),
            @ApiResponse(code = 201, message = "(token验证失败)", response = String.class),
            @ApiResponse(code = 202, message = "(系统错误)", response = String.class)})

    public Response add(
            @ApiParam(required = true, value = "用户名", name = "userName") @RequestParam String userName,
            @ApiParam(required = true, value = "密码", name = "passWord") @RequestParam String passWord
    ) {
        return userService.addUser(userName, passWord);
    }

    @ResponseBody
    @RequestMapping(value = "/getUserList/{pageNum}/{pageSize}", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有用户列表", httpMethod = "POST", notes = "获取用户")
    public Response<PageObj<List<User>>> getUserList(
            @ApiParam(required = true, value = "当前页面", name = "pageNum") @PathVariable Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", name = "pageSize") @PathVariable Integer pageSize,
            @ApiParam(required = true, value = "userListFind", name = "userListFind") @RequestBody UserListFind userListFind,
            HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            token = request.getParameter("Authorization");
        }
        User user = JwtUtils.unsign(token, User.class);
        String corporationid = user.getCorporationid();
        userListFind.setCorporationId(corporationid);
        return userService.getUserList(pageNum, pageSize, userListFind);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口", httpMethod = "POST", notes = "登录")
    public Response<User> login(
            @ApiParam(required = true, value = "用户名密码", name = "LoginVo") @RequestBody LoginVo loginVo
    ) {
        return userService.login(loginVo.getName(), loginVo.getPassword());
    }

    @ResponseBody
    @RequestMapping(value = "/refreshToken", method = RequestMethod.POST)
    @ApiOperation(value = "更新token", httpMethod = "POST", notes = "更新token")
    public Response<User> login(HttpServletRequest request,
                                @ApiParam(required = true, value = "旧token", name = "token") @RequestParam String token) {

        String token1 = request.getHeader("access_token");
        if (token1 == null) {
            token1 = request.getParameter("access_token");
        }
        return userService.refreshToken(token, token1);
    }


    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户userId获取用户信息", httpMethod = "GET", notes = "获取用户")
    public Response<User> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id", name = "userId") @RequestParam String userId
    ) {
        return userService.getUserById(userId);
    }
}
