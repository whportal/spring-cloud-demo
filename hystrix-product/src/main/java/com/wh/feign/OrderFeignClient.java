package com.wh.feign;

import com.wh.entity.User;
import com.wh.feign.fallback.OrderFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangwenhao
 * @description OrderFeignClient
 * @date 2020-06-17 09:36
 */
@FeignClient(name = "hystrix-order",fallback = OrderFeignClientFallback.class)
// @RequestMapping("/order-server/order") 配置了降级方法后不能使用该注解
public interface OrderFeignClient {

    @GetMapping("/order/user/{id}")
    User getById(@PathVariable("id") Long id);
}
