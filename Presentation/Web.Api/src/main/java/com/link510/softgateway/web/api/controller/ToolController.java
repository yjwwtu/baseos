package com.link510.softgateway.web.api.controller;

import com.link510.softgateway.services.Uploads;
import com.link510.softgateway.web.framework.controller.BaseApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "ApiToolController")
public class ToolController extends BaseApiController {

    @Autowired
    Uploads uploads;


    @RequestMapping(value = "tool/getuptoken")
    public String getUpToken() {
        return uploads.getUpToken();
    }

}
