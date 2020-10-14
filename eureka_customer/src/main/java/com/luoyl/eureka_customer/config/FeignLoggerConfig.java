package com.luoyl.eureka_customer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggerConfig {
    @Bean
    public Logger.Level feignConfiguration(){
        //return Logger.Level.BASIC;
        //return Logger.Level.HEADERS;
        //return Logger.Level.NONE;
        return Logger.Level.FULL;
    }
}
