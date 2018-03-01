package com.zw.cf.service;

import com.zw.plug.Response;

import java.io.InputStream;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface FileService {
    Response add(InputStream file,String id, String corporationid);
    Response upToken();
    Response delete(String key);
}
