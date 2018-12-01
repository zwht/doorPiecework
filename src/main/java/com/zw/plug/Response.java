package com.zw.plug;

import javax.validation.ConstraintViolation;
import java.util.*;

/**
 * Created by zhaowei on 2017/6/29.
 */
public class Response<D> {
    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Integer code = 200;
    private D data;
    private String msg;
    private List<Map<String, String>> msgObj;


    public Response success() {
        this.setMsg(OK);
        return this;
    }

    public Response success(D data) {
        this.setMsg(OK);
        this.setData(data);
        return this;
    }

    public Response failure(Integer code) {
        this.setMsg(ERROR);
        this.setCode(code);
        return this;
    }

    public Response failure(Integer code, String msg) {
        this.setMsg(msg);
        this.setCode(code);
        return this;
    }

    public Response failure(Integer code, List msgObj) {
        this.setMsg("验证错误");
        this.setMsgObj(msgObj);
        this.setCode(code);
        return this;
    }

    public Response validation(Set<ConstraintViolation> constraintViolations) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            Map<String, String> violatorList = new HashMap<String, String>();
            violatorList.put("key", constraintViolation.getPropertyPath().toString());
            violatorList.put("msg", constraintViolation.getMessage());
            violatorList.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
            list.add(violatorList);
        }
        return this.failure(401, list);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Map<String, String>> getMsgObj() {
        return msgObj;
    }

    public void setMsgObj(List<Map<String, String>> msgObj) {
        this.msgObj = msgObj;
    }
}
