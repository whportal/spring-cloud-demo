package com.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangwenhao
 * @description GatewayApplication
 * @date 2020-07-03 09:39
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class SleuthGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthGatewayApplication.class, args);
    }
}
