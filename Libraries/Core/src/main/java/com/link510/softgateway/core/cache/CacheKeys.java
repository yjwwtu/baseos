/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.cache;

/**
 * Created by cqnews on 2017/12/14.
 * 缓存键
 */
public class CacheKeys {


    /**
     * 获通过IP取地址区域信息缓存键
     */
    public static final String BASE_REGIONS_GETREGIONIDBYIP = "baseregionsgetregionidbyip";

    /**
     * 新闻列表缓存
     */
    public static final String NEWS_CATEGORY_LIST = "newscategorylist";


    /**
     * 插件
     */
    public static final String Plugin_List = "pluginlist";

    /**
     * 微信token
     */
    public static final String Wechat_Access_Token = "wechataccesstoken";


    /**
     * 微信缓存
     */
    public static final String WeChat_Session = "wechatsession";


    /**
     * 通过用户名称获取用户信息
     */
    public static final String GET_PARTUSER_USERNAME = "partuserbyusername";

    /**
     * 用户分组权限id
     */
    public static final String GET_USER_AUTHOR_ROLE_LIST = "userauthorrolelist";

    /**
     * 角色权限列表
     */
    public static final String GET_ROLE_AUTHOR_ACTION_LIST = "roleauthoractionlist";


    /**
     * 分类缓存
     */
    public static final String CATEGORY_TYPEID_PARENTID_LIST = "categorytypeidparentidlist";

    /**
     * 分类单节点缓存
     */
    public static final String CATEGORY_CATEGORYINFO_CATEID = "categorycategoryinfocateid";

    /**
     * 获取所有节点分类
     */
    public static final String CATEGORY_ALLCATEINFOLIST = "categoryallcateinfolist";


    /**
     * 圈子首页发现列表的分类
     */
    public static final String FORUM_FINDSPECIE_HOME_FORUMLIST = "forumfindspeciehomeforumlist";


    /**
     * 获取首页的缓存banner
     */
    public static final String GET_HOME_BANNER_LIST = "gethomebannerlist";
}
