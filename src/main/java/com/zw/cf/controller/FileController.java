package com.zw.cf.controller;

/**
 * Created by zhaowei on 2017/11/20.
 */

import com.zw.cf.vo.TokenVo;
import io.swagger.annotations.*;
import com.zw.cf.model.User;
import com.zw.cf.service.FileService;
import com.zw.plug.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;


/**
 * Created by zhaowei on 2017/6/24.
 */
@Api(value = "file", description = "文件管理")
@Controller("fileAction")
@Scope("prototype")
@RequestMapping("/cfmy")


public class FileController {
    @Autowired
    FileService fileService;

    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @ResponseBody
    @RequestMapping(value = "/file/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加用户")
    public Response add(@RequestParam("file") CommonsMultipartFile file,
                        @ApiParam(required = true, value = "产品ID", name = "id") @RequestParam String id,
                        HttpServletRequest request) throws IOException {

        TokenVo tokenVo= (TokenVo) request.getAttribute("tokenVo");
        //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
        InputStream is = file.getInputStream();
        Response response = fileService.add(is, id, tokenVo.getCorporationId());
        is.close();
        return response;
    }

    /*
     * 获取upToken
     */
    @ResponseBody
    @RequestMapping(value = "/public/file/upToken", method = RequestMethod.GET)
    @ApiOperation(value = "upToken", httpMethod = "GET", notes = "upToken")
    public Response upToken() throws IOException {
        return fileService.upToken();
    }

    /*
     * 删除图片
     */
    @ResponseBody
    @RequestMapping(value = "/file/delete", method = RequestMethod.GET)
    @ApiOperation(value = "delete", httpMethod = "GET", notes = "delete")
    public Response delete(
            @ApiParam(required = true, value = "key", name = "key") @RequestParam String key
    ) throws IOException {
        return fileService.delete(key);
    }


}
