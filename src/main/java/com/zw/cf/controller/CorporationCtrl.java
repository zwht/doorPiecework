package com.zw.cf.controller;

import com.wordnik.swagger.annotations.*;
import com.zw.cf.model.Corporation;
import com.zw.cf.model.User;
import com.zw.cf.service.CorporationService;
import com.zw.cf.vo.CorporationListFind;

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
public class CorporationCtrl {

    @Autowired
    CorporationService corporationService;


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加公司", httpMethod = "POST", notes = "添加公司")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加公司")})

    public Response add(
            @ApiParam(required = true, value = "corporationListFind", name = "corporationListFind") @RequestBody Corporation corporation
    ) {
        return corporationService.addCorporation(corporation);
    }

    @ResponseBody
    @RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有用户列表", httpMethod = "POST", notes = "获取用户")
    public Response<PageObj<List<User>>> getUserList(
            @ApiParam(required = true, value = "当前页面", name = "pageNum") @PathVariable Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", name = "pageSize") @PathVariable Integer pageSize,
            @ApiParam(required = true, value = "corporationListFind", name = "corporationListFind") @RequestBody CorporationListFind corporationListFind
    ) {
        return corporationService.getCorporationList(pageNum, pageSize, corporationListFind);
    }

    @ResponseBody
    @RequestMapping(value = "/getCorporation", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户userId获取用户信息", httpMethod = "GET", notes = "获取用户")
    public Response<User> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id", name = "userId") @RequestParam String userId
    ) {
        return corporationService.getCorporationById(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除公司", httpMethod = "GET", notes = "删除公司")
    public Response<User> del(
            @ApiParam(required = true, value = "id", name = "id") @RequestParam String id
    ) {
        return corporationService.del(id);
    }
}
