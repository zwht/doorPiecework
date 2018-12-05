package com.zw.cf.controller;

import io.swagger.annotations.*;
import com.zw.cf.model.Code;
import com.zw.cf.model.User;
import com.zw.cf.service.CodeService;
import com.zw.cf.vo.requestVo.ReqCodeVo;
import com.zw.plug.PageObj;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhaowei on 2017/12/11.
 */
@Api(value = "code", description = "码表")
@Controller("codeAction")
@Scope("prototype")
@RequestMapping("/cfmy")
public class CodeController {

    @Autowired
    CodeService codeService;


    @ResponseBody
    @RequestMapping(value = "/code/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加")})
    public Response add(
            @ApiParam(required = true, value = "code", name = "code") @RequestBody Code code
    ) {
        return codeService.add(code);
    }

    @ResponseBody
    @RequestMapping(value = "/public/code/list", method = RequestMethod.POST)
    @ApiOperation(value = "获取码表列表", httpMethod = "POST")
    public Response<PageObj<List<Code>>> List(
            @ApiParam(required = true, value = "当前页面", name = "pageNum", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", name = "pageSize", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(required = true, value = "reqCodeVo", name = "reqCodeVo") @RequestBody ReqCodeVo reqCodeVo
            ) {

        return codeService.list(pageNum, pageSize, reqCodeVo);
    }

    @ResponseBody
    @RequestMapping(value = "/code/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取", httpMethod = "GET")
    public Response<User> getById(
            @ApiParam(required = true, value = "Id", name = "Id") @RequestParam String id
    ) {
        return codeService.getById(id);
    }


    @ResponseBody
    @RequestMapping(value = "/code/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "更新")})
    public Response update(
            @ApiParam(required = true, value = "code", name = "code") @RequestBody Code code
    ) {
        return codeService.update(code);
    }

    @ResponseBody
    @RequestMapping(value = "/code/del", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除", httpMethod = "GET")
    public Response<User> del(
            @ApiParam(required = true, value = "id", name = "id") @RequestParam String id
    ) {
        return codeService.del(id);
    }
}
