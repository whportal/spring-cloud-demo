package com.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 注解@SpringCloudApplication 集成了@SpringBootApplication @EnableCircuitBreaker @EnableDiscoveryClient三个注解
 *
 * @author wangwenhao
 * @description SentinelOrderRestApplication
 * @date 2020-06-16 14:12
 */
@EnableEurekaClient
@SpringBootApplication
public class SentinelOrderRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelOrderRestApplication.class, args);
    }
}
