package com.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 注解@SpringCloudApplication 集成了@SpringBootApplication @EnableCircuitBreaker @EnableDiscoveryClient三个注解
 *
 * @author wangwenhao
 * @description SentinelProductRestApplication
 * @date 2020-06-17 09:19
 */
@EnableEurekaClient
@SpringBootApplication
public class SentinelProductRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelProductRestApplication.class, args);
    }
}
