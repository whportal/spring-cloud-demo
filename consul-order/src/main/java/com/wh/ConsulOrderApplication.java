package com.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangwenhao
 * @description ConsulOrderApplication
 * @date 2020-06-17 14:27
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsulOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderApplication.class, args);
    }
}
