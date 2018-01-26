package com.zw.cf.model;

import java.util.Date;

public class Door {
    private String id;

    private String name;

    private String img;

    private String corporationId;

    private String gxIds;

    private Date createTime;

    private Integer state;

    private String gxValues;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId == null ? null : corporationId.trim();
    }

    public String getGxIds() {
        return gxIds;
    }

    public void setGxIds(String gxIds) {
        this.gxIds = gxIds == null ? null : gxIds.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getGxValues() {
        return gxValues;
    }

    public void setGxValues(String gxValues) {
        this.gxValues = gxValues == null ? null : gxValues.trim();
    }
}