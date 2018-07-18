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

package com.link510.softgateway.core.message;

import java.io.Serializable;

public class MessageInfo implements Serializable {

    /**
     * 消息分类
     */
    private Integer type = 0;


    /**
     * 消息状态
     */
    private Integer state = 0;

    /**
     * 消息说明
     */
    private String message = "青沃科技欢迎您";


    /**
     * 消息正文
     */
    private Object content;

    public MessageInfo() {
    }

    public MessageInfo(String message) {
        this.message = message;
    }


    public MessageInfo(Integer type, Integer state, String message) {
        this.type = type;
        this.state = state;
        this.message = message;
    }

    public MessageInfo(Integer type, Integer state, String message, Object content) {
        this.type = type;
        this.state = state;
        this.message = message;
        this.content = content;
    }



    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "type=" + type +
                ", state=" + state +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
