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
package com.cqwo.xxx.web.api.model;

public class WechatPayModel {


    /// <summary>
    /// 时间戳
    /// </summary>
    private String timeStamp = "";

    /// <summary>
    /// 随机字符串
    /// </summary>
    private String nonceStr = "";

    /**
     * 数据包
     */
    private String packageValue = "";

    /**
     * 支付签名
     */
    private String paySign = "";

    public WechatPayModel() {
    }

    public WechatPayModel(String timeStamp, String nonceStr, String packageValue, String paySign) {
        this.timeStamp = timeStamp;
        this.nonceStr = nonceStr;
        this.packageValue = packageValue;
        this.paySign = paySign;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    @Override
    public String toString() {
        return "WechatPayModel{" +
                "timeStamp='" + timeStamp + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", packageValue='" + packageValue + '\'' +
                ", paySign='" + paySign + '\'' +
                '}';
    }
}
