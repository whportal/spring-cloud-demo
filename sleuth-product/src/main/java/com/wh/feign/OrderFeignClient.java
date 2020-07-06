package com.wh.feign;

import com.wh.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangwenhao
 * @description OrderFeignClient
 * @date 2020-06-17 09:36
 */
@FeignClient(name = "sleuth-order")
@RequestMapping("/order-server/order")
public interface OrderFeignClient {

    @GetMapping("user/{id}")
    User getById(@PathVariable("id") Long id);
}
