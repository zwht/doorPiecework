package com.zw.cf.service;

import com.zw.cf.model.Code;
import com.zw.cf.vo.CodeListFind;
import com.zw.plug.Response;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface CodeService {
    Response add(Code code);
    Response list(Integer pageNum, Integer pageSize, CodeListFind codeListFind);
    Response getById(String id);
    Response update(Code code);
    Response del(String id);
}
