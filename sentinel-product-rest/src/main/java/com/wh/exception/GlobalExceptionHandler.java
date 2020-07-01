package com.wh.exception;

import com.wh.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author wangwenhao
 * @description 全局异常处理
 * @date 2020-07-01 10:05
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> globalExceptionHandler(Exception exception) {
        if (exception instanceof UndeclaredThrowableException) {
            return Result.failed("触发了熔断降级");
        }
        return Result.failed();
    }
}
