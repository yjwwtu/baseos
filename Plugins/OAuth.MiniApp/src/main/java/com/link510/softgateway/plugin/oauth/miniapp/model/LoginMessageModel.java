/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.plugin.oauth.miniapp.model;

import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.domain.users.UserRankInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.domain.users.UserRankInfo;

/**
 * Created by cqnews on 2017/12/25.
 */
public class LoginMessageModel {

    /**
     * 用户登录成功Uid
     */
    private int uid = -1;


    /**
     * 用户登录token
     */
    private String token = "";

    /**
     * 唯一邀请码
     */
    private String invitCode = "";


    /**
     * 用户模型
     */
    private PartUserInfo partUserInfo;

    /**
     * 用户分组
     */
    private UserRankInfo userRankInfo;


    public LoginMessageModel() {
    }


    public LoginMessageModel(int uid, String token, String invitCode, PartUserInfo partUserInfo, UserRankInfo userRankInfo) {
        this.uid=uid;
        this.token=token;
        this.invitCode=invitCode;
        this.partUserInfo=partUserInfo;
        this.userRankInfo=userRankInfo;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid=uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token=token;
    }

    public String getInvitCode() {
        return invitCode;
    }

    public void setInvitCode(String invitCode) {
        this.invitCode=invitCode;
    }

    public PartUserInfo getPartUserInfo() {
        return partUserInfo;
    }

    public void setPartUserInfo(PartUserInfo partUserInfo) {
        this.partUserInfo=partUserInfo;
    }

    public UserRankInfo getUserRankInfo() {
        return userRankInfo;
    }

    public void setUserRankInfo(UserRankInfo userRankInfo) {
        this.userRankInfo=userRankInfo;
    }

    @Override
    public String toString() {
        return "LoginMessageModel{" +
                "uid=" + uid +
                ", token='" + token + '\'' +
                ", invitCode='" + invitCode + '\'' +
                ", partUserInfo=" + partUserInfo +
                ", userRankInfo=" + userRankInfo +
                '}';
    }
}
