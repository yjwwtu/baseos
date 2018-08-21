/*
 *
 *  *
 *  *  * Copyright (C) 2018.
 *  *  * 用于JAVA项目开发
 *  *  * 重庆青沃科技有限公司 版权所有
 *  *  * Copyright (C)  2018.  CqingWo Systems Incorporated. All rights reserved.
 *  *
 *
 */

package com.cqwo.xxx.plugin.oauth.miniapp.model;

public class CheckWxOpenSignatureModel {


    /**
     * openId
     */
    private String openId;

    /**
     * 验证签名内容
     */
    private String rawData;


    /**
     * 验证签名串
     */
    private String signature;

    public CheckWxOpenSignatureModel() {
    }

    public CheckWxOpenSignatureModel(String openId, String rawData, String signature) {
        this.openId = openId;
        this.rawData = rawData;
        this.signature = signature;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "CheckWxOpenSignatureModel{" +
                "openId='" + openId + '\'' +
                ", rawData='" + rawData + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
