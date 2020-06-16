package com.wh.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wangwenhao
 * @description ProductFeign
 * @date 2020-06-16 14:10
 */
@FeignClient(name = "product")
public interface ProductFeign {


}
