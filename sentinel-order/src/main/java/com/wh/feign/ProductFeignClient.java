package com.wh.feign;

import com.wh.entity.Product;
import com.wh.feign.fallback.ProductFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangwenhao
 * @description ProductFeign
 * @date 2020-06-16 14:10
 */
@FeignClient(name = "sentinel-product",fallback = ProductFeignClientFallback.class)
// @RequestMapping("/product-server/product") 配置熔断降级后不能使用该注解
public interface ProductFeignClient {

    @GetMapping("/product-server/product/{id}")
    Product getById(@PathVariable("id") Long id);

}
