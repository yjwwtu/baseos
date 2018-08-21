/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.xxx.core.domain.base;

import javax.persistence.*;
import java.io.Serializable;

//定时器日志
@Entity
@Table(name = "w_commom_eventlogs")
public class EventLogInfo implements Serializable {


    private static final long serialVersionUID = 4258781435710140006L;
    /**
     * 定时器Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;

    /**
     * 关键字
     **/
    @Column(name = "key", nullable = false, length = 30)
    private String key = "";

    /**
     * 标题
     **/
    @Column(name = "title", nullable = false, length = 50)
    private String title = "";

    /**
     * 服务
     **/
    @Column(name = "server", nullable = false, length = 50)
    private String server = "";

    /**
     * 执行时间
     **/
    @Column(name = "executetime", nullable = false)
    private Integer executeTime = 0;

    public EventLogInfo() {
    }

    public EventLogInfo(Integer id) {
        this.id = id;
    }


    public EventLogInfo(String key, String title, String server, Integer executeTime) {
        this.key = key;
        this.title = title;
        this.server = server;
        this.executeTime = executeTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Integer executeTime) {
        this.executeTime = executeTime;
    }

    @Override
    public String toString() {
        return "EventLogInfo{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", server='" + server + '\'' +
                ", executeTime=" + executeTime +
                '}';
    }
}