package com.wh.service;

import com.wh.entity.Product;
import com.wh.entity.User;

/**
 * @author wangwenhao
 * @description ProductService
 * @date 2020-06-17 09:21
 */
public interface ProductService {

    Product getById(Long id);

    User getUserById(Long id);
}
