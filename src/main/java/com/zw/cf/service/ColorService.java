package com.zw.cf.service;

import com.zw.cf.model.Color;
import com.zw.cf.vo.ColorListFind;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface ColorService {
    Response add(Color door);
    Response list(Integer pageNum, Integer pageSize, ColorListFind doorListFind);
    Response getById(String id);
    Response update(Color door);
    Response del(String id);
}
