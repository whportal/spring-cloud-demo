package com.wh.feign.fallback;

import com.wh.entity.Product;
import com.wh.feign.ProductFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author wangwenhao
 * @description ProductFeignClient熔断降级类
 * @date 2020-07-01 09:29
 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Product getById(Long id) {
        Product product = new Product();
        product.setProductDesc("触发了ProductFeignClient#getById熔断降级方法");
        return null;
    }
}
