/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.domain.authors;

import javax.persistence.*;
import java.io.Serializable;

//管理日志
@Entity
@Table(name = "w_author_adminlogs")
public class AuthorLogInfo implements Serializable {

    private static final long serialVersionUID = 2844597345561609020L;
    /**
     * 日志Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logid")
    private Integer logId = 0;
    /**
     * 用户Id
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = 0;
    /**
     * 昵称
     **/
    @Column(name = "nickname", nullable = false, length = 30)
    private String nickName = "";
    /**
     * 管理组Id
     **/
    @Column(name = "admingid", nullable = false)
    private Integer adminGid = 0;
    /**
     * 管理组标题
     **/
    @Column(name = "admingtitle", nullable = false, length = 50)
    private String adminGtitle = "";
    /**
     * 操作标题
     **/
    @Column(name = "operation", nullable = false, length = 50)
    private String operation = "";
    /**
     * 描述
     **/
    @Column(name = "description", nullable = false, length = 150)
    private String description = "";
    /**
     * IP
     **/
    @Column(name = "ip", nullable = false, length = 32)
    private String ip = "";
    /**
     * 操作时间
     **/
    @Column(name = "operatetime", nullable = false, updatable = false)
    private Integer operateTime = 0;

    public AuthorLogInfo() {
    }

    public AuthorLogInfo(Integer logId) {
        this.logId = logId;
    }

    public AuthorLogInfo(Integer uid, String nickName, Integer adminGid, String adminGtitle, String operation, String description, String ip, Integer operateTime) {
        this.uid = uid;
        this.nickName = nickName;
        this.adminGid = adminGid;
        this.adminGtitle = adminGtitle;
        this.operation = operation;
        this.description = description;
        this.ip = ip;
        this.operateTime = operateTime;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAdminGid() {
        return adminGid;
    }

    public void setAdminGid(Integer adminGid) {
        this.adminGid = adminGid;
    }

    public String getAdminGtitle() {
        return adminGtitle;
    }

    public void setAdminGtitle(String adminGtitle) {
        this.adminGtitle = adminGtitle;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Integer operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "AdminLogInfo{" +
                "logId=" + logId +
                ", uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", adminGid=" + adminGid +
                ", adminGtitle='" + adminGtitle + '\'' +
                ", operation='" + operation + '\'' +
                ", description='" + description + '\'' +
                ", ip='" + ip + '\'' +
                ", operateTime=" + operateTime +
                '}';
    }
}