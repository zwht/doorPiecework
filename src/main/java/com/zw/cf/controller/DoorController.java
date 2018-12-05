package com.zw.cf.controller;

import io.swagger.annotations.*;
import com.zw.cf.model.Door;
import com.zw.cf.model.User;
import com.zw.cf.service.DoorService;
import com.zw.cf.service.UtilsService;
import com.zw.cf.vo.DoorListFind;
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
 * Created by zhaowei on 2017/12/11.
 */
@Api(value = "door", description = "门")
@Controller("doorAction")
@Scope("prototype")
@RequestMapping("/cfmy/door")
public class DoorController {

    @Autowired
    DoorService doorService;
    @Autowired
    UtilsService utilsService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加", httpMethod = "POST", notes = "添加")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加")})
    public Response add(
            @ApiParam(required = true, value = "door", name = "door") @RequestBody Door door,
            HttpServletRequest request
    ) {
        String token = request.getHeader("token");
        if (token == null) {
            token = request.getParameter("token");
        }
        User admin = JwtUtils.unsign(token, User.class);
        door.setCorporationId(admin.getCorporationId());
        return doorService.add(door);
    }

    @ResponseBody
    @RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有用户列表", httpMethod = "POST", notes = "获取用户")
    public Response<PageObj<List<User>>> List(
            @ApiParam(required = true, value = "当前页面", name = "pageNum") @PathVariable Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", name = "pageSize") @PathVariable Integer pageSize,
            @ApiParam(required = true, value = "doorListFind", name = "doorListFind") @RequestBody DoorListFind doorListFind,
            HttpServletRequest request) {
        User user = utilsService.getUser(request);
        String corporationId = user.getCorporationId();
        doorListFind.setCorporationId(corporationId);
        return doorService.list(pageNum, pageSize, doorListFind);
    }

    @ResponseBody
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取", httpMethod = "GET", notes = "获取")
    public Response<User> getById(
            @ApiParam(required = true, value = "Id", name = "Id") @RequestParam String id
    ) {
        return doorService.getById(id);
    }


    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新", httpMethod = "POST", notes = "更新")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "更新")})
    public Response update(
            @ApiParam(required = true, value = "door", name = "door") @RequestBody Door door
    ) {
        return doorService.update(door);
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除", httpMethod = "GET", notes = "删除")
    public Response<User> del(
            @ApiParam(required = true, value = "id", name = "id") @RequestParam String id
    ) {
        return doorService.del(id);
    }
}
