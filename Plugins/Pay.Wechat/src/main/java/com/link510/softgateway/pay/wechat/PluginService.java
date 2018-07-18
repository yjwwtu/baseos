package com.link510.softgateway.pay.wechat;

import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.plugin.Interface.IPayPlugin;
import com.link510.softgateway.services.Logs;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.plugin.Interface.IPayPlugin;
import com.link510.softgateway.services.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;


@Component(value = "PayWechatPluginService")
public class PluginService implements IPayPlugin {

    @Autowired
    Logs logs;

    @Override
    public String getPayUrl() {
        return "/wechat/pay";
    }

    @Override
    public Integer getPayMode() {
        return 0;
    }

    @Override
    public double getPayFee(double recordAmount, Timestamp buyTime, PartUserInfo partUserInfo) {
        return 0;
    }

    @Override
    public String getConfigUrl() {
        return "/admin/wehcat/payconfig";
    }


    @PostConstruct
    @Override
    public void initPlugin() {
        logs.Write("初始化插件");
        System.out.println("初始化插件");
    }

}
