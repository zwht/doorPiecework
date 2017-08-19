package com.zw.cf.model;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

public class User {

    private String id;

    @NotNull
    @Length(max=3)
    private String username;
    @NotNull
    @Length(min=4,max=13)
    private String password;

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
}