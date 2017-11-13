package com.zw.cf.model;

import java.util.Date;

public class Door {
    private String id;

    private String name;

    private String img;

    private String gxids;

    private Date createTime;

    private Integer state;

    private byte[] corporationId;

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

    public String getGxids() {
        return gxids;
    }

    public void setGxids(String gxids) {
        this.gxids = gxids == null ? null : gxids.trim();
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

    public byte[] getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(byte[] corporationId) {
        this.corporationId = corporationId;
    }
}