package com.wh.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.wh.exception.ExceptionUtil;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author wangwenhao
 * @description Http请求配置类
 * @date 2020-04-22 14:00
 */
@Configuration
public class RestTemplateConfig {

    @LoadBalanced
    @Bean(name = "restTemplate")
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .requestFactory(this::getOkHttp3ClientHttpRequestFactory)
                .build();
        restTemplate.getMessageConverters().stream()
                .filter(converter -> converter instanceof StringHttpMessageConverter)
                .findFirst()
                .ifPresent(stringMessageConverter -> ((StringHttpMessageConverter) stringMessageConverter).setDefaultCharset(StandardCharsets.UTF_8));
        return restTemplate;
    }

    /**
     * 配置OKHttp的具体配置
     *
     * @return 连接工厂
     */
    public OkHttp3ClientHttpRequestFactory getOkHttp3ClientHttpRequestFactory() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
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
        return new OkHttp3ClientHttpRequestFactory(okHttpClient);
    }

}
