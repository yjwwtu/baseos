/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.xxx.web.framework.workcontext;


import com.cqwo.xxx.core.config.info.BaseConfigInfo;
import com.cqwo.xxx.core.domain.authors.AuthorSessionInfo;
import com.cqwo.xxx.core.domain.base.RegionInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.domain.users.UserRankInfo;

import java.util.List;

/**
 * Created by cqnews on 2017/4/14.
 */
public class ApiWorkContext extends BaseWorkContext {


    /**
     * api账号
     */
    private String apiKey = "1311535288";

    /**
     * 密钥
     */
    private String apiSecret = "7uvF4ZfA7B2JWm0CN8Dm6F7HMIMaYszr";

    /**
     * 用户token 计算出来
     */
    private String accessToken = "";

    /**
     * 接收token
     */
    private String token = "";//Token

    /**
     * 用户openid
     */
    private String openId = "";

    /**
     * 用户sessionId
     */
    private String sessionId = "";


    public ApiWorkContext(String apiKey, String apiSecret, String accessToken, String token, String openId, String sessionId) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.accessToken = accessToken;
        this.token = token;
        this.openId = openId;
        this.sessionId = sessionId;
    }

    public ApiWorkContext(BaseConfigInfo baseConfigInfo, String title, String keywords, String description, boolean isHttpAjax, String ip, RegionInfo regionInfo, int regionId, String url, String urlReferrer, String sid, int uid, String userName, String userEmail, String userMobile, String nickName, String avatar, String password, String encryptPwd, String payCreditName, int payCreditCount, String rankCreditName, int rankCreditCount, PartUserInfo partUserInfo, int userRid, UserRankInfo userRankInfo, String userRTitle, List<AuthorSessionInfo> authorSessionList, String controller, String action, String pageKey, String imageCDN, String cssCDN, String scriptCDN, String fontCDN, String pluginCDN, int onlineUserCount, int onlineMemberCount, int onlineGuestCount, double executeTime, int executeCount, String executeDetail, String version, String copyright, String apiKey, String apiSecret, String accessToken, String token, String openId, String sessionId) {
        super(baseConfigInfo, title, keywords, description, isHttpAjax, ip, regionInfo, regionId, url, urlReferrer, sid, uid, userName, userEmail, userMobile, nickName, avatar, password, encryptPwd, payCreditName, payCreditCount, rankCreditName, rankCreditCount, partUserInfo, userRid, userRankInfo, userRTitle, authorSessionList, controller, action, pageKey, imageCDN, cssCDN, scriptCDN, fontCDN, pluginCDN, onlineUserCount, onlineMemberCount, onlineGuestCount, executeTime, executeCount, executeDetail, version, copyright);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.accessToken = accessToken;
        this.token = token;
        this.openId = openId;
        this.sessionId = sessionId;
    }


    public ApiWorkContext() {

    }


    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }


    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "ApiWorkContext{" +
                "apiKey='" + apiKey + '\'' +
                ", apiSecret='" + apiSecret + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", token='" + token + '\'' +
                ", openId='" + openId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
