package com.wh.controller;

import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "用户服务",tags = "订单服务")
public class OrderController {

    private UserService userService;

    @Autowired
    public OrderController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "根据ID查询用户信息",response = User.class)
    @GetMapping("user/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "根据ID查询产品信息",response = Product.class)
    @GetMapping("product/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return userService.getProductById(id);
    }
}
