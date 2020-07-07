package com.wh.stream.sender;

import com.wh.stream.channel.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author wangwenhao
 * @description 消息发送
 * @date 2020-07-07 10:28
 */
@Component
@EnableBinding(MyProcessor.class)
public class MessageSender {

    @Autowired
    @Qualifier(MyProcessor.OUT_PUT)
    private MessageChannel myOutput;

    // 发送消息
    public <T> void send(T message) {
        myOutput.send(MessageBuilder.withPayload(message).build());
    }
}
