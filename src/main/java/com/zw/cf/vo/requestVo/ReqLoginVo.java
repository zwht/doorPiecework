package com.zw.cf.vo.requestVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhaowei on 2017/9/18.
 */
@ApiModel(value="LoginVo",description="LoginVo")
public class ReqLoginVo {

    @ApiModelProperty(value="登录名",name="loginName",example="zw")
    private String loginName;
    @ApiModelProperty(value="密码",name="password",example="123456")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
