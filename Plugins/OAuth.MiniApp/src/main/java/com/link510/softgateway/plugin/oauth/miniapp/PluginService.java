package com.link510.softgateway.plugin.oauth.miniapp;

import com.link510.softgateway.core.plugin.Interface.IOAuthPlugin;
import com.link510.softgateway.services.Logs;
import com.link510.softgateway.core.plugin.Interface.IOAuthPlugin;
import com.link510.softgateway.services.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component(value = "OAuthMiniAppPluginService")
public class PluginService implements IOAuthPlugin {


    @Autowired
    private Logs logs;

    @Override
    public String getLoginUrl() {
        return "/";
    }

    @Override
    public String getConfigUrl() {
        return null;
    }

    @PostConstruct
    @Override
    public void initPlugin() {
        logs.Write("初始化插件");
        System.out.println("初始化插件");
    }
}
