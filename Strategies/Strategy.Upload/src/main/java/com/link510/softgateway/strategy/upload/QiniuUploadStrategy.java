package com.link510.softgateway.strategy.upload;

import com.link510.softgateway.core.upload.IUploadStrategy;
import com.link510.softgateway.core.upload.UploadFileInfo;
import com.link510.softgateway.core.upload.IUploadStrategy;
import com.link510.softgateway.core.upload.UploadFileInfo;
import com.link510.softgateway.strategy.upload.config.QiniuConfig;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component("QiniuUploadStrategy")
public class QiniuUploadStrategy implements IUploadStrategy {


    @Autowired
    QiniuConfig qiniuConfig;


    private Auth auth;
    private String upToken;


    @PostConstruct
    public void init() {
        auth = Auth.create(qiniuConfig.getAccessKey(), qiniuConfig.getSecretKey());
        upToken = auth.uploadToken(qiniuConfig.getBucket());
        System.out.println(upToken);
    }

    @Override
    public List<UploadFileInfo> fileUpload(String fload) throws Exception {
        return null;
    }


    @Override
    public String getUpToken() {

        auth = Auth.create(qiniuConfig.getAccessKey(), qiniuConfig.getSecretKey());
        upToken = auth.uploadToken(qiniuConfig.getBucket());

        return upToken;

    }
}
