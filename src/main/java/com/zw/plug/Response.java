package com.zw.plug;

import javax.validation.ConstraintViolation;
import java.util.*;

/**
 * Created by zhaowei on 2017/6/29.
 */
public class Response<D> {
    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Integer code;
    private D data;
    private String message;
    private List messageObj;

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
    public Response failure(Integer code,List messageObj) {
        meta(false,"验证错误");
        this.messageObj=messageObj;
        this.code=code;
        return this;
    }

    public Response validation(Set<ConstraintViolation> constraintViolations){
        List<Map> list = new ArrayList<Map>();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            Map<String,String> violatorList=new HashMap<String, String>();
            violatorList.put("key",constraintViolation.getPropertyPath().toString());
            violatorList.put("msg",constraintViolation.getMessage());
            list.add(violatorList);
        }
        return this.failure(401,list);
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
    public List getMessageObj() {
        return this.messageObj;
    }

    public void meta(boolean success, String message) {
        this.message = message;
        this.code=200;
    }


}
