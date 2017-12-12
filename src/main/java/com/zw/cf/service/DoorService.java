package com.zw.cf.service;

import com.zw.cf.model.Door;
import com.zw.cf.vo.DoorListFind;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface DoorService {
    Response add(Door door);
    Response list(Integer pageNum, Integer pageSize,DoorListFind doorListFind);
    Response getById(String id);
    Response update(Door door);
}
