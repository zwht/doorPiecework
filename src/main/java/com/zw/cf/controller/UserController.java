package com.zw.cf.controller;

import com.zw.cf.vo.TokenVo;
import com.zw.cf.vo.requestVo.ReqLoginVo;
import com.zw.cf.vo.responseVo.ResLoginVo;
import io.swagger.annotations.*;
import com.zw.cf.model.User;
import com.zw.cf.service.UserService;
import com.zw.cf.vo.ResetPasswordVo;
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
@Api(value = "user", description = "用户")
@Controller("userAction")
@Scope("prototype")
@RequestMapping("/cfmy")

public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加用户")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品信息"),
            @ApiResponse(code = 201, message = "(token验证失败)", response = String.class),
            @ApiResponse(code = 202, message = "(系统错误)", response = String.class)})

    public Response add(
            @ApiParam(required = true, value = "corporationListFind", name = "corporationListFind") @RequestBody User user,
            HttpServletRequest request
    ) {

        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        user.setCorporationId(tokenVo.getCorporationId());
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有用户列表", httpMethod = "POST", notes = "获取用户")
    public Response<PageObj<List<User>>> getUserList(
            @ApiParam(required = true, value = "当前页面", name = "pageNum") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", name = "pageSize") @RequestParam Integer pageSize,
            @ApiParam(required = true, value = "userListFind", name = "userListFind") @RequestBody UserListFind userListFind,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        userListFind.setCorporationId(tokenVo.getCorporationId());
        return userService.getUserList(pageNum, pageSize, userListFind);
    }

    @ResponseBody
    @RequestMapping(value = "/public/user/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口", httpMethod = "POST", notes = "登录")
    public Response<ResLoginVo> login(
            @ApiParam(required = true, value = "用户名密码", name = "LoginVo") @RequestBody ReqLoginVo reqLoginVo
    ) {
        return userService.login(reqLoginVo.getLoginName(), reqLoginVo.getPassword());
    }

    @ResponseBody
    @RequestMapping(value = "/user/refreshToken", method = RequestMethod.POST)
    @ApiOperation(value = "更新token", httpMethod = "POST", notes = "更新token")
    public Response<User> login(HttpServletRequest request,
                                @ApiParam(required = true, value = "旧token", name = "token") @RequestParam String token) {

        String token1 = request.getHeader("token");
        if (token1 == null) {
            token1 = request.getParameter("token");
        }
        return userService.refreshToken(token, token1);
    }


    @ResponseBody
    @RequestMapping(value = "/user/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户userId获取用户信息", httpMethod = "GET", notes = "获取用户")
    public Response<User> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id", name = "id", defaultValue = "121") @RequestParam String id
    ) {
        return userService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/user/detail", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户userId获取用户信息", httpMethod = "GET", notes = "获取用户")
    public Response<User> detail(HttpServletRequest request) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return userService.getUserById(tokenVo.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新", httpMethod = "POST", notes = "更新")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "更新")})
    public Response update(
            @ApiParam(required = true, value = "color", name = "color") @RequestBody User user
    ) {
        return userService.update(user);
    }

    @ResponseBody
    @RequestMapping(value = "/user/resetPassword", method = RequestMethod.POST)
    @ApiOperation(value = "更新", httpMethod = "POST", notes = "更新")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "更新")})
    public Response resetPassword(
            @ApiParam(required = true, value = "color", name = "color") @RequestBody ResetPasswordVo resetPasswordVo
    ) {
        return userService.resetPassword(resetPasswordVo);
    }


    @ResponseBody
    @RequestMapping(value = "/user/del", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除", httpMethod = "GET", notes = "删除")
    public Response del(
            @ApiParam(required = true, value = "id", name = "id") @RequestParam String id
    ) {
        return userService.del(id);
    }
}
