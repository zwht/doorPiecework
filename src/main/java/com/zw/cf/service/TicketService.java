package com.zw.cf.service;

import com.zw.cf.model.Ticket;
import com.zw.cf.vo.TicketListFind;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface TicketService {
    Response add(Ticket ticket);
    Response list(Integer pageNum, Integer pageSize, TicketListFind ticketListFind);
    Response getById(String id);
    Response update(Ticket ticket);
    Response updateState(String id,Integer state);
    Response del(String id);
}
