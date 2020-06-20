package com.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 注解@SpringCloudApplication 集成了@SpringBootApplication @EnableCircuitBreaker @EnableDiscoveryClient三个注解
 *
 * @author wangwenhao
 * @description OrderApplication
 * @date 2020-06-16 14:12
 */
@EnableEurekaClient
@SpringCloudApplication
public class HystrixOrderRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderRestApplication.class, args);
    }
}
