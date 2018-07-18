/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.strategy.log;

import com.link510.softgateway.core.log.ILogStrategy;
import com.link510.softgateway.core.log.ILogStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by cqnews on 2017/4/15.
 */
@Repository(value = "LogStrategy")
public class LogStrategy implements ILogStrategy {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 写入日志
     *
     * @param message 消息
     */
    @Override
    public void Write(String message) {
        try {

            logger.error(message);

        } catch (Exception e) {

        }

    }

    /**
     * debug输出
     *
     * @param message
     */
    public void debug(String message) {
        logger.debug(message);
    }

    /**
     * info输出
     *
     * @param message
     */
    public void info(String message) {
        logger.info(message);
    }

    /**
     * warn输出
     *
     * @param message
     */
    public void warn(String message) {
        logger.warn(message);
    }

    /**
     * error输出
     *
     * @param message
     */
    public void error(String message) {
        logger.error(message);
    }

    /**
     * fatal输出
     *
     * @param message
     */
    public void fatal(String message) {
        logger.error(message);
    }
}
