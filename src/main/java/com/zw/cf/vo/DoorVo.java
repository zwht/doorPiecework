package com.zw.cf.vo;

import com.zw.cf.model.Door;
import com.zw.cf.model.Gx;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by zhaowei on 2017/9/18.
 */
public class DoorVo extends Door {

    private List<Gx> gx;
    public DoorVo(List<Gx> gx, Door door) {
        BeanUtils.copyProperties(door,this);
        this.gx = gx;
    }

    public List<Gx> getGx() {
        return gx;
    }

    public void setGx(List<Gx> gxName) {
        this.gx = gxName;
    }
}
