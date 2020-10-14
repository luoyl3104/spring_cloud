package com.luoyl.eureka_customer.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallBack implements Client1Feign{

    @Override
    public String sayHello(String name) {
        return "Hystrix method is invoke";
    }
}
