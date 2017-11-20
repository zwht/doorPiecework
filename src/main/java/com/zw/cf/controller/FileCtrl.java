package com.zw.cf.controller;

/**
 * Created by zhaowei on 2017/11/20.
 */

import com.wordnik.swagger.annotations.*;
import com.zw.cf.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * Created by zhaowei on 2017/6/24.
 */
@Api("file")
@Controller("fileAction")
@Scope("prototype")
@RequestMapping("/cfmy/file")

public class FileCtrl {
    @Autowired
    FileService fileService;

    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加用户")
    public String  add(@RequestParam("file") CommonsMultipartFile file) throws IOException {


        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());

        try {
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            fileService.add(is);
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/success";
    }

}
