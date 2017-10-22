package com.zw.cf.vo;

/**
 * Created by zhaowei on 2017/10/22.
 */
public class UserListFind {
    private String corporationId;

    private String name;


    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String id) {
        this.corporationId = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}
