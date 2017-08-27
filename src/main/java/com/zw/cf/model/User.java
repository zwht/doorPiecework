package com.zw.cf.model;

import java.util.Date;

public class User {
    private String id;

    private String username;

    private String password;

    private String gxid;

    private Integer type;

    private String corporationid;

    private Integer usetype;

    private Date tokentime;

    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGxid() {
        return gxid;
    }

    public void setGxid(String gxid) {
        this.gxid = gxid == null ? null : gxid.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCorporationid() {
        return corporationid;
    }

    public void setCorporationid(String corporationid) {
        this.corporationid = corporationid == null ? null : corporationid.trim();
    }

    public Integer getUsetype() {
        return usetype;
    }

    public void setUsetype(Integer usetype) {
        this.usetype = usetype;
    }

    public Date getTokentime() {
        return tokentime;
    }

    public void setTokentime(Date tokentime) {
        this.tokentime = tokentime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}