package com.wh.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author wangwenhao
 * @description redis限流Key解析器配置
 * @date 2020-07-03 09:40
 */
@Configuration
public class KeyResolverConfiguration {

    /**
     * 基于请求路径的限流
     *
     * @return KeyResolver
     */
    @Bean
    @Primary
    public KeyResolver pathKeyResolver() {
        // 自定义KeyResolver
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getPath().toString());
            }
        };
    }

    /**
     * 基于IP的限流
     *
     * @return KeyResolver
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(Objects.requireNonNull(exchange.getRequest().getHeaders().getFirst("X-Forwarded-For")));
            }
        };
    }
}
