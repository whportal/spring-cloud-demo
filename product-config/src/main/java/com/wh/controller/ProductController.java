package com.wh.controller;

import com.wh.entity.Product;
import com.wh.entity.User;
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

    @Value("${product.config}")
    private String config;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return productService.getUserById(id);
    }

    @GetMapping("config")
    public String getConfig() {
        return config;
    }
}
