package com.wh.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wh.entity.Product;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 熔断降级统一处理方法
 *
 * @author wwh
 */
public class ExceptionUtil {
    public static ClientHttpResponse handleException(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        System.err.println("Oops: " + exception.getClass().getCanonicalName());
        return new SentinelClientHttpResponse("限流熔断降级");
    }

    public static Product getProductByIdBlockHandler(Long id, BlockException blockException) {
        System.out.println("触发了熔断降级方法getProductByIdBlockHandler");
        return null;
    }

    public static Product getProductByIdFallback(Long id, Throwable throwable) {
        System.out.println("触发了熔断降级方法getProductByIdFallback");
        return null;
    }
}