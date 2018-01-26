package com.zw.cf.vo;

import java.util.List;

/**
 * Created by zhaowei on 2018/1/26.
 */
public class PageObjVo {
    private Integer pageNum;
    private Integer pageSize;
    private Integer pageCount;
    private List data;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List getData() {

        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

}
