package com.wh.controller;

import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangwenhao
 * @description OrderController
 * @date 2020-06-16 14:10
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private UserService userService;

    @Autowired
    public OrderController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping("product/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return userService.getProductById(id);
    }
}
