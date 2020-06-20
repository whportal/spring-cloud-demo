package com.wh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.mapper.UserRepository;
import com.wh.response.Result;
import com.wh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

/**
 * @author wangwenhao
 * @description UserServiceImpl
 * @date 2020-06-16 17:03
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public Product getProductById(Long id) {
        String response = restTemplate.getForObject("http://hystrix-product-rest/product-server/product/" + id, String.class);
        if (Objects.nonNull(response)) {
            Result<Product> result = JSON.parseObject(response, new TypeReference<Result<Product>>() {
            });
            return result.getData();
        }
        return null;
    }

    @Override
    public String getBalanceProduct() {
        String response = restTemplate.getForObject("http://hystrix-product-rest/product-server/product/balance", String.class);
        if (Objects.nonNull(response)) {
            Result<String> result = JSON.parseObject(response, new TypeReference<Result<String>>() {
            });
            return result.getData();
        }
        return null;
    }
}
