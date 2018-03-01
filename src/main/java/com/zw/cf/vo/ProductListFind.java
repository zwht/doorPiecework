package com.zw.cf.vo;

/**
 * Created by zhaowei on 2017/10/22.
 */
public class ProductListFind {


    private String name;
    private String ticketId;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}
