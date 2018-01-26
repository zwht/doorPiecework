package com.zw.cf.vo;

import com.zw.cf.model.Door;
import org.springframework.beans.BeanUtils;

/**
 * Created by zhaowei on 2017/9/18.
 */
public class DoorVo extends Door {

    private String gxName;

    public DoorVo(String gxName, Door door) {
        BeanUtils.copyProperties(door,this);
        this.gxName = gxName;
    }

    public String getGxName() {
        return gxName;
    }

    public void setGxName(String gxName) {
        this.gxName = gxName;
    }
}
