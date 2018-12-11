package com.zw.cf.controller;

import com.zw.cf.vo.TokenVo;
import io.swagger.annotations.*;
import com.zw.cf.model.Ticket;
import com.zw.cf.model.User;
import com.zw.cf.service.TicketService;
import com.zw.cf.vo.TicketListFind;
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
@Api(value = "ticket", description = "工单")
@Controller("ticketAction")
@Scope("prototype")
@RequestMapping("/cfmy/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加", httpMethod = "POST", notes = "添加")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加")})
    public Response add(
            @ApiParam(required = true, value = "ticket", name = "ticket") @RequestBody Ticket ticket,
            HttpServletRequest request
    ) {
        TokenVo tokenVo= (TokenVo) request.getAttribute("tokenVo");
        ticket.setCorporationId(tokenVo.getCorporationId());
        return ticketService.add(ticket);
    }

    @ResponseBody
    @RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有用户列表", httpMethod = "POST", notes = "获取用户")
    public Response<PageObj<List<User>>> List(
            @ApiParam(required = true, value = "当前页面", name = "pageNum") @PathVariable Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", name = "pageSize") @PathVariable Integer pageSize,
            @ApiParam(required = true, value = "ticketListFind", name = "ticketListFind") @RequestBody TicketListFind ticketListFind,
                    HttpServletRequest request
    ) {
        TokenVo tokenVo= (TokenVo) request.getAttribute("tokenVo");
        ticketListFind.setCorporationId(tokenVo.getCorporationId());
        String roles=tokenVo.getRoles();
        if(roles.equals("3")){
            ticketListFind.setDealersId(String.valueOf(tokenVo.getId()));
        }

        return ticketService.list(pageNum, pageSize, ticketListFind);
    }

    @ResponseBody
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取", httpMethod = "GET", notes = "获取")
    public Response<User> getById(
            @ApiParam(required = true, value = "Id", name = "Id") @RequestParam String id
    ) {
        return ticketService.getById(id);
    }


    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新", httpMethod = "POST", notes = "更新")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "更新")})
    public Response update(
            @ApiParam(required = true, value = "ticket", name = "ticket") @RequestBody Ticket ticket
    ) {
        return ticketService.update(ticket);
    }

    @ResponseBody
    @RequestMapping(value = "/updateState", method = RequestMethod.GET)
    @ApiOperation(value = "更新状态", httpMethod = "get", notes = "更新状态")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "更新状态")})
    public Response updateState(
            @ApiParam(required = true, value = "id", name = "id") @RequestParam String id,
            @ApiParam(required = true, value = "state", name = "state") @RequestParam Integer state,
            HttpServletRequest request) {
        TokenVo tokenVo= (TokenVo) request.getAttribute("tokenVo");
        String roles=tokenVo.getRoles();
        return ticketService.updateState(id,state);
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除", httpMethod = "GET", notes = "删除")
    public Response<User> del(
            @ApiParam(required = true, value = "id", name = "id") @RequestParam String id
    ) {
        return ticketService.del(id);
    }
}
