package com.wh.stream.partition;

import com.wh.dto.Order;
import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

/**
 * @author wangwenhao
 * @description 自定义分区Key策略
 * @date 2020-07-07 11:19
 */
@Configuration
public class CustomPartitionKeyStrategy implements PartitionKeyExtractorStrategy {

    @Override
    public Object extractKey(Message<?> message) {
        Object payload = message.getPayload();
        if (payload instanceof Order) {
            return ((Order) payload).getConsumerId() % 2;
        }
        return null;
    }
}
