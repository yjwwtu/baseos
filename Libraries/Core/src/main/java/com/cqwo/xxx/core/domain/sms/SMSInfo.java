/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.xxx.core.domain.sms;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cqnews on 2017/3/23.
 */
@Entity
@Table(name = "w_sms")
public class SMSInfo implements Serializable {

    private static final long serialVersionUID = -2181654979352120507L;
    /**
     * 短信ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0; // 短信ID
    /**
     * 用户ID
     */
    @Column(name = "uid", nullable = false)
    private Integer uid = 1; // 用户ID
    /**
     * 短信类型
     */
    @Column(name = "type", nullable = false)
    private Integer type = 0; // 短信类型
    /**
     * Code
     */
    @Column(name = "code", nullable = false, length = 10)
    private String code = ""; // Code
    /**
     * 发送的地址
     */
    @Column(name = "mobile", nullable = false, length = 12)
    private String mobile = ""; // 发送的地址
    /**
     * 发送内容
     */
    @Column(name = "body", nullable = false, length = 80)
    private String body = ""; // 发送内容
    /**
     * 手机发送短信时间
     */
    @Column(name = "sendtime", nullable = false)
    private Integer sendTime = 0; // 手机发送短信时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getSendTime() {
        return sendTime;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    public SMSInfo() {
    }

    public SMSInfo(Integer id) {
        this.id = id;
    }


    public SMSInfo(Integer uid, Integer type, String code, String mobile, String body, Integer sendTime) {
        this.uid = uid;
        this.type = type;
        this.code = code;
        this.mobile = mobile;
        this.body = body;
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "SMSInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", body='" + body + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
