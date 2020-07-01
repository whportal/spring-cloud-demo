package com.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangwenhao
 * @description SentinelOrderApplication
 * @date 2020-06-16 14:12
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class SentinelOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelOrderApplication.class, args);
    }
}
