package com.zw.cf.controller;

import com.wordnik.swagger.annotations.*;
import com.zw.cf.model.User;
import com.zw.cf.service.CorporationService;
import com.zw.cf.service.UserService;
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
 * Created by zhaowei on 2017/10/23.
 */
@Api("corporation")
@Controller("corporationAction")
@Scope("prototype")
@RequestMapping("/cfmy/corporation")
public class corporationCtrl {

    @Autowired
    CorporationService corporationService;


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
        return corporationService.addCorporation(userName,passWord);
    }

    @ResponseBody
    @RequestMapping(value = "/getCorporationList/{pageNum}/{pageSize}", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有用户列表", httpMethod = "POST", notes = "获取用户")
    public Response<PageObj<List<User>>> getUserList(
            @ApiParam(required = true, value = "当前页面", name = "pageNum") @PathVariable Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", name = "pageSize") @PathVariable Integer pageSize,
            @ApiParam(required = true, value = "userListFind", name = "userListFind") @RequestBody UserListFind userListFind,
            HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");
        if(token==null){
            token = request.getParameter("Authorization");
        }
        User user = JwtUtils.unsign(token, User.class);
        String corporationid=user.getCorporationid();
        userListFind.setCorporationId(corporationid);
        return corporationService.getCorporationList(pageNum,pageSize,userListFind);
    }
    @ResponseBody
    @RequestMapping(value = "/getCorporation", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户userId获取用户信息", httpMethod = "GET", notes = "获取用户")
    public Response<User> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id", name = "userId") @RequestParam String userId
    ) {
        return corporationService.getCorporationById(userId);
    }
}
