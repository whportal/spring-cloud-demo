package com.wh.service;

import com.wh.entity.Product;
import com.wh.entity.User;
import com.wh.response.Result;

/**
 * @author wangwenhao
 * @description UserService
 * @date 2020-06-16 17:02
 */
public interface UserService {

    User getById(Long id);

    Product getProductById(Long id);

    String getBalanceProduct();

}
