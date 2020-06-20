package com.wh.mapper;

import com.wh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangwenhao
 * @description UserRepository
 * @date 2020-06-16 16:30
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
