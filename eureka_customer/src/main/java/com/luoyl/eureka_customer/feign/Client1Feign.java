package com.luoyl.eureka_customer.feign;

import com.luoyl.eureka_customer.entity.TUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(serviceId = "client1",fallback = FeignClientFallBack.class)
public interface Client1Feign {

    @GetMapping("client1/hello")
    String sayHello(@RequestParam("name") String name);

    @PostMapping("user/queryAll")
    List<TUser> queryAll();

}
