package com.zw.cf.vo.requestVo;

import com.zw.cf.model.Door;
import com.zw.cf.model.Gx;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by zhaowei on 2017/9/18.
 */
public class ReqDoorVo extends Door {

    private List<Gx> gx;
    public ReqDoorVo(List<Gx> gx, Door door) {
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
