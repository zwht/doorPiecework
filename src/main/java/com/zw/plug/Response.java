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
    private String message;
    private List<Map<String, String>> messageObj;


    public Response success() {
        this.setMessage(OK);
        return this;
    }

    public Response success(D data) {
        this.setMessage(OK);
        this.setData(data);
        return this;
    }

    public Response failure(Integer code) {
        this.setMessage(ERROR);
        this.setCode(code);
        return this;
    }

    public Response failure(Integer code, String message) {
        this.setMessage(message);
        this.setCode(code);
        return this;
    }

    public Response failure(Integer code, List messageObj) {
        this.setMessage("验证错误");
        this.setMessageObj(messageObj);
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Map<String, String>> getMessageObj() {
        return messageObj;
    }

    public void setMessageObj(List<Map<String, String>> messageObj) {
        this.messageObj = messageObj;
    }
}
