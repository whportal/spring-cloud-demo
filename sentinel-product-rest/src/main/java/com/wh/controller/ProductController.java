package com.wh.controller;

import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.response.Result;
import com.wh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangwenhao
 * @description ProductController
 * @date 2020-06-17 09:28
 */
@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Value("${server.port}")
    private String port;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public Result<Product> getById(@PathVariable("id") Long id) {
        return Result.success(productService.getById(id));
    }

    @GetMapping("user/{id}")
    public Result<User> getUserById(@PathVariable("id") Long id) {
        return Result.success(productService.getUserById(id));
    }

    @GetMapping("balance")
    public Result<String> getBalanceIp() {
        return Result.success(ip + ":" + port);
    }

    @GetMapping("balance/order")
    public Result<String> getBalanceOrder() {
        return Result.success(productService.getBalanceOrder());
    }
}
