package com.luoyl.eureka_customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(serviceId = "client1",fallback = FeignClientFallBack.class)
public interface Client1Feign {

    @GetMapping("client1/hello")
    String sayHello(@RequestParam("name") String name);
}
