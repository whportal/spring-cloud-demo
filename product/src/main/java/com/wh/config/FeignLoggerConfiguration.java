package com.wh.config;

import feign.Logger;
import feign.Request;
import feign.Response;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author wangwenhao
 * @description FeignLoggerConfiguration
 * @date 2020-06-17 10:08
 */
@Configuration
public class FeignLoggerConfiguration {

    @Bean
    public InfoFeignLoggerFactory infoFeignLoggerFactory() {
        return new InfoFeignLoggerFactory();
    }

    public static class InfoFeignLoggerFactory implements FeignLoggerFactory {

        @Override
        public Logger create(Class<?> type) {
            return new InfoFeignLogger(LoggerFactory.getLogger(type));
        }
    }

    public static class InfoFeignLogger extends Logger {

        private final org.slf4j.Logger logger;

        public InfoFeignLogger(org.slf4j.Logger logger) {
            this.logger = logger;
        }

        @Override
        protected void log(String configKey, String format, Object... args) {
            // info 级别
            if (logger.isInfoEnabled()) {
                this.logger.info(String.format(methodTag(configKey) + format, args));
            }
        }

        @Override
        protected void logRequest(String configKey, Level logLevel, Request request) {
            // info 级别
            if (logger.isInfoEnabled()) {
                super.logRequest(configKey, logLevel, request);
            }
        }

        @Override
        protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
            // info 级别
            if (logger.isInfoEnabled()) {
                return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
            }
            return response;
        }
    }

}
