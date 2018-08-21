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

//用户细节
@Entity
@Table(name = "w_user_userdetails")
public class UserDetailInfo implements Serializable {

    private static final long serialVersionUID = 2785982437694600133L;
    /**
     * 记录Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;
    /**
     * Uid
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = 0;
    /**
     * 最后访问时间
     **/
    @Column(name = "lastvisittime", nullable = false)
    private Integer lastVisitTime = 0;
    /**
     * 最后访问ip
     **/
    @Column(name = "lastvisitip", nullable = false, length = 30)
    private String lastVisitIP = "";
    /**
     * 最后访问区域id
     **/
    @Column(name = "lastvisitrgid", nullable = false)
    private Integer lastVisitRgid = 0;
    /**
     * 用户注册时间
     **/
    @Column(name = "registertime", nullable = false)
    private Integer registerTime = 0;
    /**
     * 用户注册ip
     **/
    @Column(name = "registerip", nullable = false, length = 30)
    private String registerIP = "";
    /**
     * 用户注册区域id
     **/
    @Column(name = "registerrgid", nullable = false)
    private Integer registerRgid = 0;
    /**
     * 用户性别(0代表未知，1代表男，2代表女)
     **/
    @Column(name = "gender", nullable = false)
    private Integer gender = 0;
    /**
     * 生日
     **/
    @Column(name = "birthday", nullable = false)
    private Integer birthday = 0;
    /**
     * 身份证号
     **/
    @Column(name = "idcard", nullable = false, length = 30)
    private String idCard = "";
    /**
     * bio
     **/
    @Column(name = "bio", nullable = false, length = 500)
    private String bio = "";

    public UserDetailInfo() {
    }

    public UserDetailInfo(Integer id) {
        this.id = id;
    }

    public UserDetailInfo(Integer uid, Integer lastVisitTime, String lastVisitIP, Integer lastVisitRgid, Integer registerTime, String registerIP, Integer registerRgid, Integer gender, Integer birthday, String idCard, String bio) {
        this.uid = uid;
        this.lastVisitTime = lastVisitTime;
        this.lastVisitIP = lastVisitIP;
        this.lastVisitRgid = lastVisitRgid;
        this.registerTime = registerTime;
        this.registerIP = registerIP;
        this.registerRgid = registerRgid;
        this.gender = gender;
        this.birthday = birthday;
        this.idCard = idCard;
        this.bio = bio;
    }


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

    public Integer getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Integer lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public String getLastVisitIP() {
        return lastVisitIP;
    }

    public void setLastVisitIP(String lastVisitIP) {
        this.lastVisitIP = lastVisitIP;
    }

    public Integer getLastVisitRgid() {
        return lastVisitRgid;
    }

    public void setLastVisitRgid(Integer lastVisitRgid) {
        this.lastVisitRgid = lastVisitRgid;
    }

    public Integer getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Integer registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterIP() {
        return registerIP;
    }

    public void setRegisterIP(String registerIP) {
        this.registerIP = registerIP;
    }

    public Integer getRegisterRgid() {
        return registerRgid;
    }

    public void setRegisterRgid(Integer registerRgid) {
        this.registerRgid = registerRgid;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "UserDetailInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", lastVisitTime=" + lastVisitTime +
                ", lastVisitIP='" + lastVisitIP + '\'' +
                ", lastVisitRgid=" + lastVisitRgid +
                ", registerTime=" + registerTime +
                ", registerIP='" + registerIP + '\'' +
                ", registerRgid=" + registerRgid +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}