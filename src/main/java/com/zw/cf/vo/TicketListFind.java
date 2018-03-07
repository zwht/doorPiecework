package com.zw.cf.vo;

import com.google.gson.JsonArray;

import java.util.List;

/**
 * Created by zhaowei on 2017/10/22.
 */
public class TicketListFind {

    private List<Integer> state;


    private String dealersId;
    private String corporationId;

    public List<Integer> getState() {
        return state;
    }

    public void setState(List<Integer> state) {
        this.state = state;
    }

    public String getDealersId() {
        return dealersId;
    }

    public void setDealersId(String dealersId) {
        this.dealersId = dealersId;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}
