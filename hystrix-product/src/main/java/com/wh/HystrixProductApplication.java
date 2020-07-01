package com.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 注解@SpringCloudApplication 集成了@SpringBootApplication @EnableCircuitBreaker @EnableDiscoveryClient三个注解
 *
 * @author wangwenhao
 * @description ProductApplication
 * @date 2020-06-17 09:19
 */
@EnableHystrixDashboard
@EnableEurekaClient
@EnableFeignClients
@SpringCloudApplication
public class HystrixProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixProductApplication.class, args);
    }
}
