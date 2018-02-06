package com.zw.cf.vo;

/**
 * Created by zhaowei on 2017/10/22.
 */
public class LineListFind {


    private String corporationId;

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
