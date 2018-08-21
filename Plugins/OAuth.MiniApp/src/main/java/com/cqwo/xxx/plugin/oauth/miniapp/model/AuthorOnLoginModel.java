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

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;

public class AuthorOnLoginModel {

    private String sessionId = "";

    /**
     * 用户OpenId
     **/
    private String openId = "";

    /**
     * unionId
     */
    private String unionId = "";

    /**
     * SessionKey
     **/
    private String sessionKey = "";

    /**
     * 用户Uid
     **/
    private int uid = -1;

    /**
     * Token
     **/
    private String token = "";

    /**
     * 用户基本信息
     **/
    private PartUserInfo userInfo;

    public AuthorOnLoginModel() {
    }

    public AuthorOnLoginModel(String openId, String unionId, String sessionKey) {

        this.openId = openId;
        this.unionId = unionId;
        this.sessionKey = sessionKey;
    }

    public AuthorOnLoginModel(String openId, String unionId, String sessionKey, int uid, String token, PartUserInfo userInfo) {

        this.openId = openId;
        this.unionId = unionId;
        this.sessionKey = sessionKey;
        this.sessionId = sessionKey;
        this.uid = uid;
        this.token = token;
        this.userInfo = userInfo;
    }

    public AuthorOnLoginModel(WxMaJscode2SessionResult result) {
        this.openId = result.getOpenid();
        this.unionId = result.getUnionid();
        this.sessionKey = result.getSessionKey();
        this.sessionId = this.sessionKey;


        this.uid = -1;
        this.token = "";
        this.userInfo = new PartUserInfo();
    }


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public PartUserInfo getUserInfo(PartUserInfo partUserInfo) {
        return userInfo;
    }

    public void setUserInfo(PartUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "AuthorOnLoginModel{" +
                ", openId='" + openId + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", uid=" + uid +
                ", token='" + token + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
