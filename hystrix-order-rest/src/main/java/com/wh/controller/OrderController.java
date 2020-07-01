package com.wh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.response.Result;
import com.wh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wangwenhao
 * @description OrderController
 * @date 2020-06-16 14:10
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private UserService userService;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Value("${server.port}")
    private String port;

    @Autowired
    public OrderController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{id}")
    public Result<User> getById(@PathVariable("id") Long id) {
        return Result.success(userService.getById(id));
    }

    @GetMapping("product/{id}")
    @HystrixCommand(fallbackMethod = "productFallBack")
    public Result<Product> getProductById(@PathVariable("id") Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return Result.success(userService.getProductById(id));
    }

    @GetMapping("balance")
    public Result<String> getBalanceIp() {
        return Result.success(ip + ":" + port);
    }

    @GetMapping("balance/product")
    @HystrixCommand(fallbackMethod = "balanceFallBack")
    public Result<String> getBalanceProduct() {
        return Result.success(userService.getBalanceProduct());
    }

    /**
     * 降级方法 需要和被降级的接口的参数和返回值保持一致
     *
     * @return Result
     */
    public Result<String> balanceFallBack() {
        return Result.failed("熔断:触发降级方法");
    }

    /**
     * 降级方法 需要和被降级的接口的参数和返回值保持一致
     *
     * @return Result
     */
    public Result<Product> productFallBack(Long id) {
        return Result.success("熔断:触发降级方法", null);
    }
}
