package com.zw.cf.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.zw.cf.service.FileService;
import com.zw.plug.Response;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by zhaowei on 2017/8/17.
 */
@Service
public class FileServiceImplImpl implements FileService {

    Response response1 = new Response();
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone2());
    //...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);
    //...生成上传凭证，然后准备上传
    String accessKey = "IBLCYav5ECJaqeEqyUeojfhLEC5wkN4tM0BsQi2S";
    String secretKey = "4_uIHTtisPV2UuxoniJC-wpHhAzim6HujhcdmDYF";
    String bucket = "piecework";
    //默认不指定key的情况下，以文件内容的hash值作为文件名
    String key = null;

    Auth auth = Auth.create(accessKey, secretKey);


    public Response upToken() {
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        long expireSeconds = 3600;
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
        return response1.success(upToken);
    }


    public Response add(InputStream file, String id, String corporationid) {
        Response response1 = new Response();
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        long expireSeconds = 3600;
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
        try {
            com.qiniu.http.Response response = uploadManager.put(file, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            //修改名字
            Auth auth1 = Auth.create(accessKey, secretKey);
            BucketManager bucketManager = new BucketManager(auth1, cfg);
            try {
                String imgId = id + "-cfmy-" + corporationid;

                bucketManager.move(bucket, putRet.hash, bucket, imgId);

                String domainOfBucket = "http://ozq3tirki.bkt.clouddn.com";
                String finalUrl = String.format("%s/%s", domainOfBucket, imgId);

                return response1.success(finalUrl);
            } catch (QiniuException ex) {
                //如果遇到异常，说明移动失败
                return response1.failure(501, ex.response.toString());
            }
        } catch (QiniuException ex) {
            return response1.failure(501, ex.response.toString());
        }
    }


    public Response delete(String key) {
        Response response1 = new Response();
        Response upToken = this.upToken();

        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
            return response1.success(key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            return response1.failure(501, ex.response.toString());
        }
    }
}
