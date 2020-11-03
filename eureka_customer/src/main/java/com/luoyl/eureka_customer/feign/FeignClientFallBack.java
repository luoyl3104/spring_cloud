package com.luoyl.eureka_customer.feign;

import com.luoyl.eureka_customer.entity.TUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignClientFallBack implements Client1Feign{

    @Override
    public String sayHello(String name) {
        return "Hystrix method is invoke";
    }

    @Override
    public List<TUser> queryAll() {
        return null;
    }
}
