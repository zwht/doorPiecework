package com.zw.cf.service;

import com.zw.cf.model.Process;
import com.zw.cf.vo.ProcessListFind;
import com.zw.plug.Response;

import java.util.List;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface ProcessService {
    Response add(Process process);
    Response addList(List<Process> list);
    Response list(Integer pageNum, Integer pageSize, ProcessListFind processListFind);
    Response getById(String id);
    Response update(Process process);
    Response del(String id);

}
