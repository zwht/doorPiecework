package com.zw.cf.model;

import java.util.Date;

public class Ticket {
    private String id;

    private String name;

    private String dealersId;

    private String brandId;

    private String odd;

    private String address;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date overTime;

    private String productIds;

    private String corporationId;

    private Integer state;

    private String number;

    private Float pay;

    private Float sumDoor;

    private Float sumTaoban;

    private Float sumLine;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDealersId() {
        return dealersId;
    }

    public void setDealersId(String dealersId) {
        this.dealersId = dealersId == null ? null : dealersId.trim();
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getOdd() {
        return odd;
    }

    public void setOdd(String odd) {
        this.odd = odd == null ? null : odd.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds == null ? null : productIds.trim();
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId == null ? null : corporationId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Float getPay() {
        return pay;
    }

    public void setPay(Float pay) {
        this.pay = pay;
    }

    public Float getSumDoor() {
        return sumDoor;
    }

    public void setSumDoor(Float sumDoor) {
        this.sumDoor = sumDoor;
    }

    public Float getSumTaoban() {
        return sumTaoban;
    }

    public void setSumTaoban(Float sumTaoban) {
        this.sumTaoban = sumTaoban;
    }

    public Float getSumLine() {
        return sumLine;
    }

    public void setSumLine(Float sumLine) {
        this.sumLine = sumLine;
    }
}