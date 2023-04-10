
package com.luoyl.eureka_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableCaching
public class EurekaRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRedisApplication.class, args);
    }

}
