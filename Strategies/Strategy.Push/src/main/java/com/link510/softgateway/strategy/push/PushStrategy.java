package com.link510.softgateway.strategy.push;

import com.link510.softgateway.core.message.MessageInfo;
import com.link510.softgateway.core.push.IPushStrategy;
import com.link510.softgateway.core.message.MessageInfo;
import com.link510.softgateway.core.push.IPushStrategy;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component(value = "PushStrategy")
public class PushStrategy implements IPushStrategy {
    @Override
    public boolean send(String deviceToken, String title, String text, MessageInfo messageInfo) throws IOException {
        return false;
    }

    @Override
    public boolean send(String title, String text, MessageInfo messageInfo) throws IOException {
        return false;
    }
}
