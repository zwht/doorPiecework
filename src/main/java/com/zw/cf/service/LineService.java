package com.zw.cf.service;

import com.zw.cf.model.Line;
import com.zw.cf.vo.LineListFind;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface LineService {
    Response add(Line line);
    Response list(Integer pageNum, Integer pageSize, LineListFind lineListFind);
    Response getById(String id);
    Response update(Line line);
}
