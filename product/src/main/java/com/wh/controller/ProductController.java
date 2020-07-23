package com.wh.controller;

import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "产品服务")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "根据ID查询产品信息",response =Product.class )
    @GetMapping("{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @ApiOperation(value = "根据ID查询用户信息",response =User.class )
    @GetMapping("user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return productService.getUserById(id);
    }
}
