package com.zw.cf.service;

import java.io.InputStream;

/**
 * Created by zhaowei on 2017/8/17.
 */
public interface FileService {
    com.zw.plug.Response add(InputStream file,String id, String corporationid);

}
