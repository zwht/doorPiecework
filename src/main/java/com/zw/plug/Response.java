package com.zw.plug;

/**
 * Created by zhaowei on 2017/6/29.
 */
public class Response<D> {
    private static final String OK = "ok";
    private static final String ERROR = "error";

    private String message;
    private Integer code;
    private D data;

    public Response success() {
        meta(true, OK);
        return this;
    }

    public Response success(D data) {
        meta(true, OK);
        this.data = data;
        return this;
    }

    public Response failure(Integer code) {
        meta(false, ERROR);
        this.code=code;
        return this;
    }

    public Response failure(Integer code,String message) {
        meta(false, message);
        this.code=code;
        return this;
    }

    public D getData() {
        return this.data;
    }
    public String getMessage() {
        return this.message;
    }
    public Integer getCode() {
        return this.code;
    }

    public void meta(boolean success, String message) {
        this.message = message;
        this.code=200;
    }


}
