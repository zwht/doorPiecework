package com.zw.cf.model;

public class Color {
    private Integer id;

    private String color;

    private String croporationid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getCroporationid() {
        return croporationid;
    }

    public void setCroporationid(String croporationid) {
        this.croporationid = croporationid == null ? null : croporationid.trim();
    }
}