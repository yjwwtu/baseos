/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.domain.users;

import javax.persistence.*;
import java.io.Serializable;

//用户
@Entity
@Table(name = "w_users")
public class PartUserInfo implements Serializable {


    private static final long serialVersionUID = -812194532736924613L;
    /**
     * 用户Uid
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Integer uid;


    /**
     * 用户名
     **/
    @Column(name = "username", nullable = false, length = 20)
    private String userName = "";
    /**
     * 邮箱
     **/
    @Column(name = "email", nullable = false, length = 30)
    private String email = "";
    /**
     * 手机
     **/
    @Column(name = "mobile", nullable = false, length = 12)
    private String mobile = "";
    /**
     * 密码
     **/
    @Column(name = "password", nullable = false, length = 32)
    private String password = "";
    /**
     * 用户等级
     **/
    @Column(name = "userrid", nullable = false)
    private Integer userRid = 0;

//    /**
//     * 管理组
//     **/
//    @Column(name = "admingid", nullable = false)
//    private Integer adminGid = 0;
    /**
     * 昵称
     **/
    @Column(name = "nickname", nullable = false, length = 30)
    private String nickName = "";

    /**
     * 推荐人
     */
    @Column(name = "parentid", nullable = false)
    private Integer parentId = 0;

    /**
     * 真实姓名
     **/
    @Column(name = "realname", nullable = false, length = 10)
    private String realName = "";
    /**
     * 头像
     **/
    @Column(name = "avatar", nullable = false, length = 255)
    private String avatar = "";
    /**
     * 所在区域
     **/
    @Column(name = "regionid", nullable = false)
    private Integer regionId = 0;
    /**
     * 地址
     **/
    @Column(name = "address", nullable = false, length = 255)
    private String address = "";
    /**
     * 经度
     **/
    @Column(name = "longitude", nullable = false)
    private double longitude = 0.00;
    /**
     * 纬度
     **/
    @Column(name = "latitude", nullable = false)
    private double latitude = 0.00;
    /**
     * 可支付积分
     **/
    @Column(name = "paycredits", nullable = false)
    private Integer payCredits = 0;
    /**
     * 积分等级
     **/
    @Column(name = "rankcredits", nullable = false)
    private Integer rankCredits = 0;
    /**
     * 用户余额
     **/
    @Column(name = "money", nullable = false)
    private double money = 0.00;
    /**
     * 消费等级
     **/
    @Column(name = "rankmoney", nullable = false)
    private double rankMoney = 0.00;

    /**
     * 邀请码
     */
    @Column(name = "invitcode", nullable = false, length = 30)
    private String invitCode = "";

    /**
     * 是否验证邮箱
     **/
    @Column(name = "verifyemail", nullable = false)
    private Integer verifyEmail = 0;
    /**
     * 是否验证手机
     **/
    @Column(name = "verifymobile", nullable = false)
    private Integer verifyMobile = 0;
    /**
     * 解禁时间
     **/
    @Column(name = "liftbantime", nullable = false)
    private Integer liftBanTime = 0;
    /**
     * 盐值
     **/
    @Column(name = "salt", nullable = false, length = 18)
    private String salt = "";

    public PartUserInfo() {
    }

    public PartUserInfo(Integer uid) {
        this.uid = uid;
    }

    public PartUserInfo(String userName, String email, String mobile, String password, Integer userRid, String nickName, Integer parentId, String realName, String avatar, Integer regionId, String address, double longitude, double latitude, Integer payCredits, Integer rankCredits, double money, double rankMoney, String invitCode, Integer verifyEmail, Integer verifyMobile, Integer liftBanTime, String salt) {
        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.userRid = userRid;
        this.nickName = nickName;
        this.parentId = parentId;
        this.realName = realName;
        this.avatar = avatar;
        this.regionId = regionId;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.payCredits = payCredits;
        this.rankCredits = rankCredits;
        this.money = money;
        this.rankMoney = rankMoney;
        this.invitCode = invitCode;
        this.verifyEmail = verifyEmail;
        this.verifyMobile = verifyMobile;
        this.liftBanTime = liftBanTime;
        this.salt = salt;
    }

    public PartUserInfo(Integer uid, String userName, String email, String mobile, Integer userRid, String nickName, String realName) {
        this.uid = uid;
        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.userRid = userRid;
        this.nickName = nickName;
        this.realName = realName;
    }

    public PartUserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserRid() {
        return userRid;
    }

    public void setUserRid(Integer userRid) {
        this.userRid = userRid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Integer getPayCredits() {
        return payCredits;
    }

    public void setPayCredits(Integer payCredits) {
        this.payCredits = payCredits;
    }

    public Integer getRankCredits() {
        return rankCredits;
    }

    public void setRankCredits(Integer rankCredits) {
        this.rankCredits = rankCredits;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getRankMoney() {
        return rankMoney;
    }

    public void setRankMoney(double rankMoney) {
        this.rankMoney = rankMoney;
    }

    public String getInvitCode() {
        return invitCode;
    }

    public void setInvitCode(String invitCode) {
        this.invitCode = invitCode;
    }

    public Integer getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(Integer verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public Integer getVerifyMobile() {
        return verifyMobile;
    }

    public void setVerifyMobile(Integer verifyMobile) {
        this.verifyMobile = verifyMobile;
    }

    public Integer getLiftBanTime() {
        return liftBanTime;
    }

    public void setLiftBanTime(Integer liftBanTime) {
        this.liftBanTime = liftBanTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "PartUserInfo{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", userRid=" + userRid +
                ", nickName='" + nickName + '\'' +
                ", parentId=" + parentId +
                ", realName='" + realName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", regionId=" + regionId +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", payCredits=" + payCredits +
                ", rankCredits=" + rankCredits +
                ", money=" + money +
                ", rankMoney=" + rankMoney +
                ", invitCode='" + invitCode + '\'' +
                ", verifyEmail=" + verifyEmail +
                ", verifyMobile=" + verifyMobile +
                ", liftBanTime=" + liftBanTime +
                ", salt='" + salt + '\'' +
                '}';
    }
}