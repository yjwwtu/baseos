/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.web.framework.workcontext;

import com.link510.softgateway.core.config.info.BaseConfigInfo;
import com.link510.softgateway.core.domain.authors.AuthorSessionInfo;
import com.link510.softgateway.core.domain.base.RegionInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.domain.users.UserRankInfo;
import com.link510.softgateway.core.CWMVersion;
import com.link510.softgateway.core.config.info.BaseConfigInfo;
import com.link510.softgateway.core.domain.authors.AuthorSessionInfo;
import com.link510.softgateway.core.domain.base.RegionInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.domain.users.UserRankInfo;

import java.util.List;

public class BaseWorkContext {

    /**
     * 项目基本配置
     */
    private BaseConfigInfo baseConfigInfo = new BaseConfigInfo();

    /**
     * 标题
     */
    private String title = "英卡电子";

    /**
     * 关键词
     */
    private String keywords = "英卡电子";

    /**
     * 描述
     */
    private String description = "英卡电子";


    /**
     * 当前请求是否为ajax请求
     */
    private boolean isHttpAjax = false;
    /**
     * 用户ip
     */
    private String IP = "127.0.0.1";//用户ip

    /**
     * 区域信息
     */
    private RegionInfo regionInfo = new RegionInfo();//区域信息

    /**
     * 区域id
     */
    private int regionId = 0;//区域id

    /**
     * 当前url
     */
    private String url = "";//当前url

    /**
     * 上一次访问的url
     */
    private String urlReferrer = "";//上一次访问的url

    /**
     * 用户sid
     */
    private String sid = "";//用户sid

    /**
     * 用户id
     */
    private int uid = -1;//用户id

    /**
     * 用户名
     */
    private String userName = "agent";//用户名

    /**
     * 用户邮箱
     */
    private String userEmail = "123@163.com";//用户邮箱

    /**
     * 用户手机号
     */
    private String userMobile = "138";//用户手机号

    /**
     * 用户昵称
     */
    private String nickName = "游客";//用户昵称

    /**
     * 用户头像
     */
    private String avatar = "";//用户头像

    /**
     * 用户密码
     */
    private String password = "";//用户密码

    /**
     * 加密密码
     */
    private String encryptPwd = "";//加密密码

    /**
     * 支付积分名称
     */
    private String payCreditName = "";//支付积分名称

    /**
     * 支付积分数量
     */
    private int payCreditCount = 0;//支付积分数量

    /**
     * 等级积分名称
     */
    private String rankCreditName = "金币";//等级积分名称

    /**
     * 等级积分数量
     */
    private int rankCreditCount = 0;//等级积分数量

    /**
     * 用户信息
     */
    private PartUserInfo partUserInfo;//用户信息

    /**
     * 用户等级id
     */
    private int userRid = -1;//用户等级id

    /**
     * 用户等级信息
     */
    private UserRankInfo userRankInfo;//用户等级信息

    /**
     * 用户等级标题
     */
    private String userRTitle = "游客";//用户等级标题


    /**
     * 用户软件管理员组信息
     */
    private List<AuthorSessionInfo> authorSessionList;//用户软件管理员组信息

    /**
     * 控制器
     */
    private String controller = "home";//控制器

    /**
     * 动作方法
     */
    private String action = "action";//动作方法

    /**
     * 页面标示符
     */
    private String pageKey = "homeaction";//页面标示符

    /**
     * 图片cdn
     */
    private String imageCDN = "/static/admin/images";//图片cdn

    /**
     * csscdn
     */
    private String cssCDN = "/static/admin/css";//csscdn

    /**
     * 脚本cdn
     */
    private String scriptCDN = "/static/admin/scripts";//脚本cdn

    /**
     * 字体cdn
     */
    private String fontCDN = "/static/admin/fonts";//字体cdn

    /**
     * 插件路径
     */
    private String pluginCDN = "/components";//插件路径

    /**
     * 在线总人数
     */
    private int onlineUserCount = 0;//在线总人数

    /**
     * 在线会员数
     */
    private int onlineMemberCount = 0;//在线会员数

    /**
     * 在线游客数
     */
    private int onlineGuestCount = 0;//在线游客数


    /**
     * 页面执行时间
     */
    private double executeTime = 0;//页面执行时间

    /**
     * 执行的sql语句数目
     */
    private int executeCount = 0;//执行的sql语句数目

    /**
     * 执行的sql语句细节
     */
    private String executeDetail = "";//执行的sql语句细节

    /**
     * 软件版本
     */
    private String version = CWMVersion.VERSION;//软件版本

    /**
     * 软件版权
     */
    private String copyright = CWMVersion.COPYRIGHT;//软件版权

    public BaseWorkContext() {
    }


    public BaseWorkContext(BaseConfigInfo baseConfigInfo, String title, String keywords, String description, boolean isHttpAjax, String IP, RegionInfo regionInfo, int regionId, String url, String urlReferrer, String sid, int uid, String userName, String userEmail, String userMobile, String nickName, String avatar, String password, String encryptPwd, String payCreditName, int payCreditCount, String rankCreditName, int rankCreditCount, PartUserInfo partUserInfo, int userRid, UserRankInfo userRankInfo, String userRTitle, List<AuthorSessionInfo> authorSessionList, String controller, String action, String pageKey, String imageCDN, String cssCDN, String scriptCDN, String fontCDN, String pluginCDN, int onlineUserCount, int onlineMemberCount, int onlineGuestCount, double executeTime, int executeCount, String executeDetail, String version, String copyright) {
        this.baseConfigInfo = baseConfigInfo;
        this.title = title;
        this.keywords = keywords;
        this.description = description;
        this.isHttpAjax = isHttpAjax;
        this.IP = IP;
        this.regionInfo = regionInfo;
        this.regionId = regionId;
        this.url = url;
        this.urlReferrer = urlReferrer;
        this.sid = sid;
        this.uid = uid;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.nickName = nickName;
        this.avatar = avatar;
        this.password = password;
        this.encryptPwd = encryptPwd;
        this.payCreditName = payCreditName;
        this.payCreditCount = payCreditCount;
        this.rankCreditName = rankCreditName;
        this.rankCreditCount = rankCreditCount;
        this.partUserInfo = partUserInfo;
        this.userRid = userRid;
        this.userRankInfo = userRankInfo;
        this.userRTitle = userRTitle;
        this.authorSessionList = authorSessionList;
        this.controller = controller;
        this.action = action;
        this.pageKey = pageKey;
        this.imageCDN = imageCDN;
        this.cssCDN = cssCDN;
        this.scriptCDN = scriptCDN;
        this.fontCDN = fontCDN;
        this.pluginCDN = pluginCDN;
        this.onlineUserCount = onlineUserCount;
        this.onlineMemberCount = onlineMemberCount;
        this.onlineGuestCount = onlineGuestCount;
        this.executeTime = executeTime;
        this.executeCount = executeCount;
        this.executeDetail = executeDetail;
        this.version = version;
        this.copyright = copyright;
    }

    public BaseConfigInfo getBaseConfigInfo() {
        return baseConfigInfo;
    }

    public void setBaseConfigInfo(BaseConfigInfo baseConfigInfo) {
        this.baseConfigInfo = baseConfigInfo;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isHttpAjax() {
        return isHttpAjax;
    }

    public void setHttpAjax(boolean httpAjax) {
        isHttpAjax = httpAjax;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public RegionInfo getRegionInfo() {
        return regionInfo;
    }

    public void setRegionInfo(RegionInfo regionInfo) {
        this.regionInfo = regionInfo;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlReferrer() {
        return urlReferrer;
    }

    public void setUrlReferrer(String urlReferrer) {
        this.urlReferrer = urlReferrer;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptPwd() {
        return encryptPwd;
    }

    public void setEncryptPwd(String encryptPwd) {
        this.encryptPwd = encryptPwd;
    }

    public String getPayCreditName() {
        return payCreditName;
    }

    public void setPayCreditName(String payCreditName) {
        this.payCreditName = payCreditName;
    }

    public int getPayCreditCount() {
        return payCreditCount;
    }

    public void setPayCreditCount(int payCreditCount) {
        this.payCreditCount = payCreditCount;
    }

    public String getRankCreditName() {
        return rankCreditName;
    }

    public void setRankCreditName(String rankCreditName) {
        this.rankCreditName = rankCreditName;
    }

    public int getRankCreditCount() {
        return rankCreditCount;
    }

    public void setRankCreditCount(int rankCreditCount) {
        this.rankCreditCount = rankCreditCount;
    }

    public PartUserInfo getPartUserInfo() {
        return partUserInfo;
    }

    public void setPartUserInfo(PartUserInfo partUserInfo) {
        this.partUserInfo = partUserInfo;
    }

    public int getUserRid() {
        return userRid;
    }

    public void setUserRid(int userRid) {
        this.userRid = userRid;
    }

    public UserRankInfo getUserRankInfo() {
        return userRankInfo;
    }

    public void setUserRankInfo(UserRankInfo userRankInfo) {
        this.userRankInfo = userRankInfo;
    }

    public String getUserRTitle() {
        return userRTitle;
    }

    public void setUserRTitle(String userRTitle) {
        this.userRTitle = userRTitle;
    }


    public List<AuthorSessionInfo> getAuthorSessionList() {
        return authorSessionList;
    }

    public void setAuthorSessionList(List<AuthorSessionInfo> authorSessionList) {
        this.authorSessionList = authorSessionList;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPageKey() {
        return pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

    public String getImageCDN() {
        return imageCDN;
    }

    public void setImageCDN(String imageCDN) {
        this.imageCDN = imageCDN;
    }

    public String getCssCDN() {
        return cssCDN;
    }

    public void setCssCDN(String cssCDN) {
        this.cssCDN = cssCDN;
    }

    public String getScriptCDN() {
        return scriptCDN;
    }

    public void setScriptCDN(String scriptCDN) {
        this.scriptCDN = scriptCDN;
    }

    public int getOnlineUserCount() {
        return onlineUserCount;
    }

    public void setOnlineUserCount(int onlineUserCount) {
        this.onlineUserCount = onlineUserCount;
    }

    public int getOnlineMemberCount() {
        return onlineMemberCount;
    }

    public void setOnlineMemberCount(int onlineMemberCount) {
        this.onlineMemberCount = onlineMemberCount;
    }

    public int getOnlineGuestCount() {
        return onlineGuestCount;
    }

    public void setOnlineGuestCount(int onlineGuestCount) {
        this.onlineGuestCount = onlineGuestCount;
    }

    public double getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(double executeTime) {
        this.executeTime = executeTime;
    }

    public int getExecuteCount() {
        return executeCount;
    }

    public void setExecuteCount(int executeCount) {
        this.executeCount = executeCount;
    }

    public String getExecuteDetail() {
        return executeDetail;
    }

    public void setExecuteDetail(String executeDetail) {
        this.executeDetail = executeDetail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getFontCDN() {
        return fontCDN;
    }

    public void setFontCDN(String fontCDN) {
        this.fontCDN = fontCDN;
    }

    public String getPluginCDN() {
        return pluginCDN;
    }

    public void setPluginCDN(String pluginCDN) {
        this.pluginCDN = pluginCDN;
    }

    @Override
    public String toString() {
        return "BaseWorkContext{" +
                "baseConfigInfo=" + baseConfigInfo +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", isHttpAjax=" + isHttpAjax +
                ", IP='" + IP + '\'' +
                ", regionInfo=" + regionInfo +
                ", regionId=" + regionId +
                ", url='" + url + '\'' +
                ", urlReferrer='" + urlReferrer + '\'' +
                ", sid='" + sid + '\'' +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", encryptPwd='" + encryptPwd + '\'' +
                ", payCreditName='" + payCreditName + '\'' +
                ", payCreditCount=" + payCreditCount +
                ", rankCreditName='" + rankCreditName + '\'' +
                ", rankCreditCount=" + rankCreditCount +
                ", partUserInfo=" + partUserInfo +
                ", userRid=" + userRid +
                ", userRankInfo=" + userRankInfo +
                ", userRTitle='" + userRTitle + '\'' +
                ", authorSessionList=" + authorSessionList +
                ", controller='" + controller + '\'' +
                ", action='" + action + '\'' +
                ", pageKey='" + pageKey + '\'' +
                ", imageCDN='" + imageCDN + '\'' +
                ", cssCDN='" + cssCDN + '\'' +
                ", scriptCDN='" + scriptCDN + '\'' +
                ", fontCDN='" + fontCDN + '\'' +
                ", pluginCDN='" + pluginCDN + '\'' +
                ", onlineUserCount=" + onlineUserCount +
                ", onlineMemberCount=" + onlineMemberCount +
                ", onlineGuestCount=" + onlineGuestCount +
                ", executeTime=" + executeTime +
                ", executeCount=" + executeCount +
                ", executeDetail='" + executeDetail + '\'' +
                ", version='" + version + '\'' +
                ", copyright='" + copyright + '\'' +
                '}';
    }
}
