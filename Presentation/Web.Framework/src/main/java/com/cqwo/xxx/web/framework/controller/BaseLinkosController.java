/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.xxx.web.framework.controller;

import com.cqwo.xxx.web.framework.workcontext.WebWorkContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "linkos")
public class BaseLinkosController extends BaseController {


    protected WebWorkContext workContext;

    public BaseLinkosController() {

    }

    @Override
    public WebWorkContext getWorkContext() {
        return workContext;
    }

    @ModelAttribute
    public void setInitialize(HttpServletResponse response) throws IOException {

        this.response = response;
        this.workContext = new WebWorkContext();
        this.session = request.getSession();





    }


    @ModelAttribute
    public void inspectInitialize() {

        System.out.println("inspectInitialize被执行了");
    }
}
