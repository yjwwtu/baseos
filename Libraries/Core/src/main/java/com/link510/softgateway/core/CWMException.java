/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core;

/**
 * Created by cqnews on 2017/3/20.
 */
public class CWMException extends Exception{

    public CWMException() {
    }

    public CWMException(String message) {
        super(message);
    }

    public CWMException(String message, Throwable cause) {
        super(message, cause);
    }

    public CWMException(Throwable cause) {
        super(cause);
    }

    public CWMException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
