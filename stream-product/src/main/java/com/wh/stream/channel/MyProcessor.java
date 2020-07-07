package com.wh.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author wangwenhao
 * @description 自定义消息通道
 * @date 2020-07-07 10:25
 */
public interface MyProcessor {

    String OUT_PUT = "myOutput";

    String INPUT = "myInput";

    @Output(OUT_PUT)
    MessageChannel myOutput();

    @Input(INPUT)
    SubscribableChannel myInput();

}
