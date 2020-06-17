package com.wh.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author wangwenhao
 * @description Feign底层使用OKHttp访问配置
 * @date 2020-06-16 16:14
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignClientOkHttpConfiguration {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                // 连接池
                .connectionPool(new ConnectionPool(200, 5, TimeUnit.MINUTES))
                // 连接超时
                .connectTimeout(30L, TimeUnit.SECONDS)
                // 写超时
                .writeTimeout(30L, TimeUnit.SECONDS)
                // 读取超时
                .readTimeout(30L, TimeUnit.SECONDS)
                // 自动重连
                .retryOnConnectionFailure(true)
                .build();
    }
}
