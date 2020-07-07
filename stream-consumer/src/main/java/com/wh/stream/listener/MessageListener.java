package com.wh.stream.listener;

import com.wh.stream.channel.MyProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wangwenhao
 * @description 消息接收
 * @date 2020-07-07 10:50
 */
@Component
@EnableBinding(MyProcessor.class)
public class MessageListener {

    @StreamListener(MyProcessor.INPUT)
    public void input(Message<String> message) {
        System.err.println("Receive Message: " + message.getPayload());
    }
}
