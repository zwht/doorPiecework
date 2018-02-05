package com.zw.cf.vo;

import com.zw.cf.model.Gx;
import com.zw.cf.model.Process;
import com.zw.cf.model.User;
import org.springframework.beans.BeanUtils;

/**
 * Created by zhaowei on 2017/9/18.
 */
public class ProcessVo extends Process {

    private User user;
    private Gx gx;
    public ProcessVo(Gx gx, User user, Process process) {
        BeanUtils.copyProperties(process,this);
        this.gx = gx;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Gx getGx() {
        return gx;
    }

    public void setGx(Gx gx) {
        this.gx = gx;
    }
}
