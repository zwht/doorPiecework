package com.zw.cf.vo;

import com.zw.cf.model.Process;

import java.util.List;

/**
 * Created by zhaowei on 2018/1/29.
 */
public class AddListProcessVo {
    private List<Process> processs;
    private String ticketId;

    public List<Process> getProcesss() {
        return processs;
    }

    public void setProcesss(List<Process> processs) {
        this.processs = processs;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
