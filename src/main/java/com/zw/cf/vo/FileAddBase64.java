package com.zw.cf.vo;

/**
 * Created by zhaowei on 2017/10/22.
 */
public class FileAddBase64 {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

}
