package com.zw.cf.vo.requestVo;

/**
 * Created by zhaowei on 2017/10/22.
 */
public class ReqCodeVo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}
