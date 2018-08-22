package com.cqwo.xxx.strategy.push;

import com.cqwo.xxx.core.message.MessageInfo;
import com.cqwo.xxx.core.push.IPushStrategy;
import com.cqwo.xxx.core.message.MessageInfo;
import com.cqwo.xxx.core.push.IPushStrategy;
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
