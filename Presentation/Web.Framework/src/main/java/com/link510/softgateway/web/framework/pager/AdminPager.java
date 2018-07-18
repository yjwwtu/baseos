/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.web.framework.pager;

import com.link510.softgateway.web.framework.model.PageModel;
import com.link510.softgateway.web.framework.model.PageModel;

/**
 * Created by cqnews on 2017/12/14.
 */
public class AdminPager {

    private PageModel pageModel;

    public AdminPager(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override
    public String toString() {
        return "AdminPager{" +
                "pageModel=" + pageModel +
                '}';
    }
}
