package com.wh.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author wangwenhao
 * @description 全局认证过滤器
 * @date 2020-07-03 09:19
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求的URI
        ServerHttpRequest request = exchange.getRequest();
        String uri = request.getURI().getPath();
        // 登录接口放行
        if (uri.contains("/login" )|| uri.contains("api-docs")||uri.contains("doc")) {
            return chain.filter(exchange);
        }

        // 模拟token认证
        String token = request.getQueryParams().getFirst("token");
        if (StringUtils.isEmpty(token)) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器优先级 数字越小 优先级越高
     *
     * @return 优先级
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
