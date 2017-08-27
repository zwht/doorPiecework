package com.zw.cf.model;

import java.util.Date;

public class Ticket {
    private String id;

    private String name;

    private String dealersid;

    private String brandid;

    private String odd;

    private String address;

    private Date starttime;

    private Date endtime;

    private Date creattime;

    private Date overtime;

    private String processids;

    private String corporationid;

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

    public String getDealersid() {
        return dealersid;
    }

    public void setDealersid(String dealersid) {
        this.dealersid = dealersid == null ? null : dealersid.trim();
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid == null ? null : brandid.trim();
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    public String getProcessids() {
        return processids;
    }

    public void setProcessids(String processids) {
        this.processids = processids == null ? null : processids.trim();
    }

    public String getCorporationid() {
        return corporationid;
    }

    public void setCorporationid(String corporationid) {
        this.corporationid = corporationid == null ? null : corporationid.trim();
    }
}