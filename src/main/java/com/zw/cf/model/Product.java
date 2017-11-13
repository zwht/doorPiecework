package com.zw.cf.model;

import java.util.Date;

public class Product {
    private String id;

    private String name;

    private String doorid;

    private String processIds;

    private String img;

    private String describe;

    private Date startTime;

    private Date endTime;

    private String corporationId;

    private Integer weightCover;

    private Integer heightCover;

    private Integer depthCover;

    private Integer weight;

    private Integer height;

    private Integer weightLb;

    private Integer heightLb;

    private Integer weightDb;

    private Integer heightDb;

    private String colorId;

    private String lineId;

    private Integer lineSum;

    private String productcol;

    private Integer type;

    private Boolean isModule;

    private String moduleId;

    private Integer state;

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

    public String getProcessIds() {
        return processIds;
    }

    public void setProcessIds(String processIds) {
        this.processIds = processIds == null ? null : processIds.trim();
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

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId == null ? null : corporationId.trim();
    }

    public Integer getWeightCover() {
        return weightCover;
    }

    public void setWeightCover(Integer weightCover) {
        this.weightCover = weightCover;
    }

    public Integer getHeightCover() {
        return heightCover;
    }

    public void setHeightCover(Integer heightCover) {
        this.heightCover = heightCover;
    }

    public Integer getDepthCover() {
        return depthCover;
    }

    public void setDepthCover(Integer depthCover) {
        this.depthCover = depthCover;
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

    public Integer getWeightLb() {
        return weightLb;
    }

    public void setWeightLb(Integer weightLb) {
        this.weightLb = weightLb;
    }

    public Integer getHeightLb() {
        return heightLb;
    }

    public void setHeightLb(Integer heightLb) {
        this.heightLb = heightLb;
    }

    public Integer getWeightDb() {
        return weightDb;
    }

    public void setWeightDb(Integer weightDb) {
        this.weightDb = weightDb;
    }

    public Integer getHeightDb() {
        return heightDb;
    }

    public void setHeightDb(Integer heightDb) {
        this.heightDb = heightDb;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId == null ? null : colorId.trim();
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    public Integer getLineSum() {
        return lineSum;
    }

    public void setLineSum(Integer lineSum) {
        this.lineSum = lineSum;
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

    public Boolean getIsModule() {
        return isModule;
    }

    public void setIsModule(Boolean isModule) {
        this.isModule = isModule;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}