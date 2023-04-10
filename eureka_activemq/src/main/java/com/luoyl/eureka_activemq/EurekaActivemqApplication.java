package com.luoyl.eureka_activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@EnableEurekaClient
@SpringBootApplication
public class EurekaActivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaActivemqApplication.class, args);
    }

}
