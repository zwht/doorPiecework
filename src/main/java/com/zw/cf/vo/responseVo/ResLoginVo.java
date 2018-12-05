package com.zw.cf.vo.responseVo;

import com.zw.cf.vo.TokenVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhaowei on 2018/12/5.
 */
@ApiModel(value="loginResponseVo对象",description="loginResponseVo对象描述")
public class ResLoginVo extends TokenVo {
    @ApiModelProperty(value="token令牌",name="token",example="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDI0MjMwNDQ4MzgsInBheWxvYWQiOiJ7XCJpZFwiOlwiMTIxXCIsXCJsb2dpbk5hbWVcIjpcInp3XCIsXCJ0eXBlXCI6XCIxXCIsXCJyb2xlc1wiOlwiMFwiLFwiY29ycG9yYXRpb25JZFwiOlwiXCJ9In0.KyIinZ7bTr2qYMYT3KQBwKidlFKEHzFROjWhfYWdbw4")
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
