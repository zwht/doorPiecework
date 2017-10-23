package com.zw.cf.model;

public class Code {
    private Integer id;

    private Integer value;

    private Integer type;

    private byte[] describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public byte[] getDescribe() {
        return describe;
    }

    public void setDescribe(byte[] describe) {
        this.describe = describe;
    }
}