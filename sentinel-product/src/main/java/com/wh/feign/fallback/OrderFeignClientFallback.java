package com.wh.feign.fallback;

import com.wh.entity.User;
import com.wh.feign.OrderFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author wangwenhao
 * @description OrderFeignClient熔断降级处理类
 * @date 2020-07-01 09:32
 */
@Component
public class OrderFeignClientFallback implements OrderFeignClient {

    @Override
    public User getById(Long id) {
        User user = new User();
        user.setAddress("触发了OrderFeignClient#getById熔断降级方法");
        return null;
    }
}
