package com.zw.plug;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by zhaowei on 2017/8/16.
 */
public class Result<T> {

    private boolean isSuccess = true;

    // private Map<String,Object> param = new HashMap<String, Object>();

    private String error;

    private Map<String, Object> param = new HashMap<String, Object>();

    private T value;

    public void setValue(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }

    public void addParam(String key, Object value) {
        param.put(key, value);
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public void setError(String error){
        this.error=error;
        if (error!=null){
            this.isSuccess = false;
            this.param = null;

        }
        else{
            this.isSuccess = true;
        }

    }
    public boolean isSuccess() {
        return isSuccess;
    }



    public Map<String, Object> getParam() {
        return param;
    }

    public Object getParamValue(String key) {
        if (param == null) return null;
        return param.get(key);
    }

    public String getError() {
        return error;
    }
}
