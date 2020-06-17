package com.wh.service.impl;

import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.feign.ProductFeignClient;
import com.wh.mapper.UserRepository;
import com.wh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wangwenhao
 * @description UserServiceImpl
 * @date 2020-06-16 17:03
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ProductFeignClient productFeignClient;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProductFeignClient productFeignClient) {
        this.userRepository = userRepository;
        this.productFeignClient = productFeignClient;
    }

    @Override
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public Product getProductById(Long id) {
        Product byId = productFeignClient.getById(id);
        return byId;
    }
}
