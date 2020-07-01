package com.wh.feign.fallback;

import com.wh.entity.Product;
import com.wh.feign.ProductFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author wangwenhao
 * @description ProductFeignClient 熔断降级方法
 * @date 2020-06-30 13:52
 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    /**
     * 降级方法 不能使用异常进行中止，必须返回与被降级方法一样的对象
     *
     * @param id id
     * @return Product
     */
    @Override
    public Product getById(Long id) {
        Product product = new Product();
        product.setProductDesc("触发了ProductFeignClient#getById熔断方法");
        return product;
    }
}
