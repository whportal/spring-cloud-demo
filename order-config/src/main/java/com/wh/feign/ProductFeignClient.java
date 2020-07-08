package com.wh.feign;

import com.wh.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangwenhao
 * @description ProductFeign
 * @date 2020-06-16 14:10
 */
@FeignClient(name = "config-product")
@RequestMapping("/product-server/product")
public interface ProductFeignClient {

    @GetMapping("{id}")
    Product getById(@PathVariable("id") Long id);

}
