package com.wh.service.impl;

import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.feign.OrderFeignClient;
import com.wh.mapper.ProductRepository;
import com.wh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wangwenhao
 * @description ProductServiceImpl
 * @date 2020-06-17 09:22
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private OrderFeignClient orderFeignClient;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,OrderFeignClient orderFeignClient) {
        this.productRepository = productRepository;
        this.orderFeignClient = orderFeignClient;
    }

    @Override
    public Product getById(Long id) {
        Product product = new Product();
        product.setId(id);
        Example<Product> example = Example.of(product);
        Optional<Product> productOptional = productRepository.findOne(example);
        return productOptional.orElse(null);
    }

    @Override
    public User getUserById(Long id) {
        return orderFeignClient.getById(id);
    }
}
