package com.zw.cf.model;

import java.util.Date;

public class UserTie {
    private String id;

    private String dealersId;

    private String sellId;

    private Integer state;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDealersId() {
        return dealersId;
    }

    public void setDealersId(String dealersId) {
        this.dealersId = dealersId == null ? null : dealersId.trim();
    }

    public String getSellId() {
        return sellId;
    }

    public void setSellId(String sellId) {
        this.sellId = sellId == null ? null : sellId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}