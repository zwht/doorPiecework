package com.zw.cf.vo;


import com.zw.cf.model.Gx;
import com.zw.cf.model.Line;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by zhaowei on 2017/9/18.
 */
public class LineVo extends Line {

    private List<Gx> gx;
    public LineVo(List<Gx> gx, Line line) {
        BeanUtils.copyProperties(line,this);
        this.gx = gx;
    }

    public List<Gx> getGx() {
        return gx;
    }

    public void setGx(List<Gx> gxName) {
        this.gx = gxName;
    }
}
