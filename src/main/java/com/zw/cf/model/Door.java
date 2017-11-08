package com.zw.cf.model;

import java.util.Date;

public class Door {
    private String id;

    private String name;

    private String img;

    private String gxids;

    private Date createtime;

    private Integer state;

    private byte[] corporationid;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public byte[] getCorporationid() {
        return corporationid;
    }

    public void setCorporationid(byte[] corporationid) {
        this.corporationid = corporationid;
    }
}