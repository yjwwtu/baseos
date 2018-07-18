/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by cqnews on 2017/3/20.
 */
public class JsonHelper {

    /**
     * 将数组转换成JSON
     *
     * @param object
     * @return
     */
    public static JSON Object2Json(Object object) {
        return (JSON) JSON.toJSON(object);
    }

    /**
     * 将Json串转成JSONObject
     *
     * @param json json串
     * @return
     */
    public static JSONObject Json2Object(String json) {

        JSONObject jsonObject = JSON.parseObject(json);

        return jsonObject;

    }


}
