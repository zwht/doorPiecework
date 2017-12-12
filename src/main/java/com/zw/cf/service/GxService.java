package com.zw.cf.service;

import com.zw.cf.model.Gx;
import com.zw.cf.vo.GxListFind;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface GxService {
    Response add(Gx gx);
    Response list(Integer pageNum, Integer pageSize, GxListFind gxListFind);
    Response getById(String id);
    Response update(Gx gx);
}
