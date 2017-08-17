package com.zw.plug;

/**
 * Created by zhaowei on 2017/8/17.
 */
public class PageObj<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Long pageCount;
    private T data;

    public PageObj init(Integer pageNum,Integer pageSize, Long pageCount,T data){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.pageCount=pageCount;
        this.data=data;
        return this;
    }

    public Integer getPageNum(){
        return this.pageNum;
    }
    public Integer getPageSize(){
        return this.pageSize;
    }
    public Long getPageCount(){
        return this.pageCount;
    }
    public T getData(){
        return this.data;
    }
}
