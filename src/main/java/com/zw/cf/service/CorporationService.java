package com.zw.cf.service;
import com.zw.cf.model.Corporation;
import com.zw.cf.vo.CorporationListFind;
import com.zw.plug.Response;
/**
 * Created by zhaowei on 2017/10/23.
 */
public interface CorporationService {
    Response getCorporationById(String id);
    Response getCorporationList(Integer pageNum, Integer pageSize,CorporationListFind corporationListFind);
    Response addCorporation(Corporation corporation);
    Response del(String id);
}
