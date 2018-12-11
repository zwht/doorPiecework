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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;


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
    @RequestMapping(value = "/file/add", consumes = "multipart/*", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加用户")
    public Response add(
            @ApiParam(required = true, value = "上传文件") MultipartFile multipartFile,
            @ApiParam(value = "文件类型", name = "type") @RequestParam String type,
            HttpServletRequest request
    ) throws IllegalStateException, IOException {
        Response response = new Response();

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = "/Users/zhaowei/projects/zw/doorPiecework/images/" + type + "／" + file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }

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
