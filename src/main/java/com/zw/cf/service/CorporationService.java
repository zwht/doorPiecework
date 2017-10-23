package com.zw.cf.service;
import com.zw.cf.vo.UserListFind;
import com.zw.plug.Response;
/**
 * Created by zhaowei on 2017/10/23.
 */
public interface CorporationService {
    Response getCorporationById(String id);
    Response getCorporationList(Integer pageNum, Integer pageSize,UserListFind userListFind);
    Response addCorporation(String name,String passWord);
}
