package com.wh.feign;

import com.wh.entity.Product;
import com.wh.feign.fallback.ProductFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * * 声明需要调用的微服务名称
 *  *  @FeignClient
 *  *      * name : 服务提供者的名称
 *  *      * fallback : 配置熔断发生降级方法
 *  *                  实现类
 * @author wangwenhao
 * @description ProductFeign
 * @date 2020-06-16 14:10
 */
@FeignClient(name = "hystrix-product",fallback = ProductFeignClientFallback.class)
// @RequestMapping("/product-server/product") 配置了降级方法后不能使用该注解
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product getById(@PathVariable("id") Long id);

}
