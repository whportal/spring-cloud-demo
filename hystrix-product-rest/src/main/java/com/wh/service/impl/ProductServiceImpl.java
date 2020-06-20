package com.wh.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.mapper.ProductRepository;
import com.wh.response.Result;
import com.wh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

/**
 * @author wangwenhao
 * @description ProductServiceImpl
 * @date 2020-06-17 09:22
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private RestTemplate restTemplate;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
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
        String response = restTemplate.getForObject("http://hystrix-order-rest/order-server/order/user/" + id, String.class);
        if (Objects.nonNull(response)) {
            Gson gson = new Gson();
            Result<User> result = gson.fromJson(response, new TypeToken<Result<User>>() {
            }.getType());
            return result.getData();
        }
        return null;
    }

    @Override
    public String getBalanceOrder() {
        String response = restTemplate.getForObject("http://hystrix-order-rest/order-server/order/balance", String.class);
        if (Objects.nonNull(response)) {
            Gson gson = new Gson();
            Result<String> result = gson.fromJson(response, new TypeToken<Result<String>>() {
            }.getType());
            return result.getData();
        }
        return null;
    }
}
