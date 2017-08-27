package com.zw.cf.model;

import java.util.Date;

public class Product {
    private String id;

    private String name;

    private String doorid;

    private String processids;

    private String img;

    private String describe;

    private Date starttime;

    private Date endtime;

    private String corporationid;

    private Integer weightcover;

    private Integer heightcover;

    private Integer depthcover;

    private Integer weight;

    private Integer height;

    private Integer weightlb;

    private Integer heightlb;

    private Integer weightdb;

    private Integer heightdb;

    private String colorid;

    private String lineid;

    private Integer linesum;

    private String productcol;

    private Integer type;

    private Boolean ismodule;

    private String moduleid;

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

    public String getDoorid() {
        return doorid;
    }

    public void setDoorid(String doorid) {
        this.doorid = doorid == null ? null : doorid.trim();
    }

    public String getProcessids() {
        return processids;
    }

    public void setProcessids(String processids) {
        this.processids = processids == null ? null : processids.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
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

    public String getCorporationid() {
        return corporationid;
    }

    public void setCorporationid(String corporationid) {
        this.corporationid = corporationid == null ? null : corporationid.trim();
    }

    public Integer getWeightcover() {
        return weightcover;
    }

    public void setWeightcover(Integer weightcover) {
        this.weightcover = weightcover;
    }

    public Integer getHeightcover() {
        return heightcover;
    }

    public void setHeightcover(Integer heightcover) {
        this.heightcover = heightcover;
    }

    public Integer getDepthcover() {
        return depthcover;
    }

    public void setDepthcover(Integer depthcover) {
        this.depthcover = depthcover;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeightlb() {
        return weightlb;
    }

    public void setWeightlb(Integer weightlb) {
        this.weightlb = weightlb;
    }

    public Integer getHeightlb() {
        return heightlb;
    }

    public void setHeightlb(Integer heightlb) {
        this.heightlb = heightlb;
    }

    public Integer getWeightdb() {
        return weightdb;
    }

    public void setWeightdb(Integer weightdb) {
        this.weightdb = weightdb;
    }

    public Integer getHeightdb() {
        return heightdb;
    }

    public void setHeightdb(Integer heightdb) {
        this.heightdb = heightdb;
    }

    public String getColorid() {
        return colorid;
    }

    public void setColorid(String colorid) {
        this.colorid = colorid == null ? null : colorid.trim();
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid == null ? null : lineid.trim();
    }

    public Integer getLinesum() {
        return linesum;
    }

    public void setLinesum(Integer linesum) {
        this.linesum = linesum;
    }

    public String getProductcol() {
        return productcol;
    }

    public void setProductcol(String productcol) {
        this.productcol = productcol == null ? null : productcol.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getIsmodule() {
        return ismodule;
    }

    public void setIsmodule(Boolean ismodule) {
        this.ismodule = ismodule;
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }
}