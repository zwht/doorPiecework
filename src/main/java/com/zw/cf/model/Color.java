package com.zw.cf.model;

public class Color {
    private Integer id;

    private String color;

    private String croporationId;

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

    public String getCroporationId() {
        return croporationId;
    }

    public void setCroporationId(String croporationId) {
        this.croporationId = croporationId == null ? null : croporationId.trim();
    }
}