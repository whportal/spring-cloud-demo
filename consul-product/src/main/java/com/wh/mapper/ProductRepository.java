package com.wh.mapper;

import com.wh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangwenhao
 * @description ProductRepository
 * @date 2020-06-17 09:20
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
