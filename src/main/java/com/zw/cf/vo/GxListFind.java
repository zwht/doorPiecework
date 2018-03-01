package com.zw.cf.vo;

/**
 * Created by zhaowei on 2017/10/22.
 */
public class GxListFind {

    private String corporationId;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private Integer type;

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
