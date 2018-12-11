package com.zw.cf.vo;

import com.zw.cf.model.Door;
import org.springframework.beans.BeanUtils;

/**
 * Created by zhaowei on 2017/9/18.
 */
public class ResetPasswordVo extends Door {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    private String oldPwd;
    private String newPwd;
}
