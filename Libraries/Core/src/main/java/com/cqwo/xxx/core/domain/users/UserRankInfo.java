/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.xxx.core.domain.users;

import javax.persistence.*;
import java.io.Serializable;

//用户等级
@Entity
@Table(name = "w_user_userranks")
public class UserRankInfo implements Serializable {

    private static final long serialVersionUID = -5299034745544946079L;

    /**
     * 用户等级id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userrid")
    private Integer userRid = 6;


    /**
     * 是否是系统等级
     **/
    @Column(name = "system", nullable = false)
    private Integer system = 1;
    /**
     * 用户等级标题
     **/
    @Column(name = "title", nullable = false, length = 30)
    private String title = "6";
    /**
     * 用户等级头像
     **/
    @Column(name = "avatar", nullable = false, length = 150)
    private String avatar = "";
    /**
     * 用户等级积分上限
     **/
    @Column(name = "creditslower", nullable = false)
    private Integer creditsLower = 0;
    /**
     * 用户等级积分下限
     **/
    @Column(name = "creditsupper", nullable = false)
    private Integer creditsUpper = 0;
    /**
     * 限制天数
     **/
    @Column(name = "limitdays", nullable = false)
    private Integer limitDays = 0;

    public UserRankInfo() {

    }

    public UserRankInfo(Integer userRid) {
        this.userRid = userRid;
    }

    public UserRankInfo(Integer userRid, Integer system, String title, String avatar, Integer creditsLower, Integer creditsUpper, Integer limitDays) {
        this.userRid = userRid;
        this.system = system;
        this.title = title;
        this.avatar = avatar;
        this.creditsLower = creditsLower;
        this.creditsUpper = creditsUpper;
        this.limitDays = limitDays;
    }

    public Integer getUserRid() {
        return userRid;
    }

    public void setUserRid(Integer userRid) {
        this.userRid = userRid;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCreditsLower() {
        return creditsLower;
    }

    public void setCreditsLower(Integer creditsLower) {
        this.creditsLower = creditsLower;
    }

    public Integer getCreditsUpper() {
        return creditsUpper;
    }

    public void setCreditsUpper(Integer creditsUpper) {
        this.creditsUpper = creditsUpper;
    }

    public Integer getLimitDays() {
        return limitDays;
    }

    public void setLimitDays(Integer limitDays) {
        this.limitDays = limitDays;
    }

    @Override
    public String toString() {
        return "UserRankInfo{" +
                "userRid=" + userRid +
                ", system=" + system +
                ", title='" + title + '\'' +
                ", avatar='" + avatar + '\'' +
                ", creditsLower=" + creditsLower +
                ", creditSupper=" + creditsUpper +
                ", limitDays=" + limitDays +
                '}';
    }
}