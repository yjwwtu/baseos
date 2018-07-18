package com.link510.softgateway.plugin.oauth.miniapp.framework;

import com.link510.softgateway.web.framework.controller.BaseApiController;
import com.link510.softgateway.web.framework.controller.BaseApiController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller(value = "OauthMiniAppApiController")
public class OauthMiniAppApiController extends BaseApiController {

    @ModelAttribute
    public void setInitialize(HttpServletResponse response) throws IOException {

        super.setInitialize(response);


    }

}
