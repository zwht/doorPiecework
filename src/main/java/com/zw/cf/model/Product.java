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

    private Integer coverWidth;

    private Integer coverHeight;

    private Integer coverDepth;

    private Integer widht;

    private Integer height;

    private Integer lbWidth;

    private Integer lbHeight;

    private Integer dbWidth;

    private Integer dbHeight;

    private String colorId;

    private String lineId;

    private Integer lineSum;

    private String productcol;

    private Integer type;

    private Boolean isModule;

    private String moduleId;

    private Integer state;

    private Integer lbSum;

    private Integer dbSum;

    private Integer sum;

    private Integer lineLength;

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

    public Integer getCoverWidth() {
        return coverWidth;
    }

    public void setCoverWidth(Integer coverWidth) {
        this.coverWidth = coverWidth;
    }

    public Integer getCoverHeight() {
        return coverHeight;
    }

    public void setCoverHeight(Integer coverHeight) {
        this.coverHeight = coverHeight;
    }

    public Integer getCoverDepth() {
        return coverDepth;
    }

    public void setCoverDepth(Integer coverDepth) {
        this.coverDepth = coverDepth;
    }

    public Integer getWidht() {
        return widht;
    }

    public void setWidht(Integer widht) {
        this.widht = widht;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLbWidth() {
        return lbWidth;
    }

    public void setLbWidth(Integer lbWidth) {
        this.lbWidth = lbWidth;
    }

    public Integer getLbHeight() {
        return lbHeight;
    }

    public void setLbHeight(Integer lbHeight) {
        this.lbHeight = lbHeight;
    }

    public Integer getDbWidth() {
        return dbWidth;
    }

    public void setDbWidth(Integer dbWidth) {
        this.dbWidth = dbWidth;
    }

    public Integer getDbHeight() {
        return dbHeight;
    }

    public void setDbHeight(Integer dbHeight) {
        this.dbHeight = dbHeight;
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

    public Integer getLbSum() {
        return lbSum;
    }

    public void setLbSum(Integer lbSum) {
        this.lbSum = lbSum;
    }

    public Integer getDbSum() {
        return dbSum;
    }

    public void setDbSum(Integer dbSum) {
        this.dbSum = dbSum;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getLineLength() {
        return lineLength;
    }

    public void setLineLength(Integer lineLength) {
        this.lineLength = lineLength;
    }
}