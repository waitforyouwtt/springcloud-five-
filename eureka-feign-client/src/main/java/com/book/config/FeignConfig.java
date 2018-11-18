package com.book.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Author: 一点点
 * @Date: 2018/11/18 11:45
 * @Version 1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }
}
