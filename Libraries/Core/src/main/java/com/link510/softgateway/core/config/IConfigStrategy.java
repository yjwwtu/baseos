/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.config;

import com.link510.softgateway.core.config.info.*;


/**
 * 配置策略接口
 * Created by cqnews on 2017/3/24.
 */
public interface IConfigStrategy {



    /**
     * 保存项目基本配置
     *
     * @param configInfo 项目基本配置
     * @return 是否保存成功
     */
    boolean SaveBaseConfig(BaseConfigInfo configInfo);

    /**
     * 获得项目基本配置
     *
     * @return 项目基本配置
     */
    BaseConfigInfo getBaseConfig();

    /**
     * 保存邮件配置
     *
     * @param configInfo 邮件配置信息
     * @return 是否保存成功
     */
    boolean SaveEmailConfig(EmailConfigInfo configInfo);

    /**
     * 获得邮件配置
     *
     * @return 邮件配置
     */
    EmailConfigInfo getEmailConfig();

    /**
     * 保存短信配置
     *
     * @param configInfo 短信配置信息
     * @return 是否保存成功
     */
    boolean SaveSMSConfig(SMSConfigInfo configInfo);

    /**
     * 获得短信配置
     *
     * @return 短信配置
     */
    SMSConfigInfo getSMSConfig();

    /**
     * 保存微信配置
     *
     * @param configInfo 微信配置信息
     * @return 是否保存成功
     */
    boolean SaveWechatConfig(WechatConfigInfo configInfo);

    /**
     * 获得微信配置
     *
     * @return 微信配置
     */
    WechatConfigInfo getWechatConfig();

}
