/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.domain.base;

import javax.persistence.*;
import java.io.Serializable;

//禁用Ip
@Entity
@Table(name = "w_commom_bannedips")
public class BannedIPInfo implements Serializable {

    private static final long serialVersionUID = -7924205615914753847L;

    /**
     * 禁用Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;

    /**
     * IP
     **/
    @Column(name = "ip", nullable = false, length = 30)
    private String ip = "";

    /**
     * 禁止过期时间
     **/
    @Column(name = "liftbantime", nullable = false)
    private Integer liftBanTime = 0;

    public BannedIPInfo() {
    }

    public BannedIPInfo(Integer id) {
        this.id = id;
    }

    public BannedIPInfo(String ip, Integer liftBanTime) {
        this.ip = ip;
        this.liftBanTime = liftBanTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getLiftBanTime() {
        return liftBanTime;
    }

    public void setLiftBanTime(Integer liftBanTime) {
        this.liftBanTime = liftBanTime;
    }

    @Override
    public String toString() {
        return "BannedIPInfo{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", liftBanTime=" + liftBanTime +
                '}';
    }
}