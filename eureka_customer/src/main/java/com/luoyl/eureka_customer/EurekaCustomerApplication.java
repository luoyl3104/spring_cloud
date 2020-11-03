package com.luoyl.eureka_customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//feign
@EnableCircuitBreaker//开启熔断
@EnableSwagger2
public class EurekaCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCustomerApplication.class, args);
    }

}
