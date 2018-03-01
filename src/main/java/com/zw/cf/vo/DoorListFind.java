package com.zw.cf.vo;

/**
 * Created by zhaowei on 2017/10/22.
 */
public class DoorListFind {


    private String corporationId;
    private String name;

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}
