package com.link510.softgateway.web.api.controller;

import com.link510.softgateway.web.framework.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "ApiHomeController")
public class HomeController extends BaseApiController {


    @RequestMapping(value = {"index"})
    public String index() {
        return JsonView("测试接口");
    }


}
