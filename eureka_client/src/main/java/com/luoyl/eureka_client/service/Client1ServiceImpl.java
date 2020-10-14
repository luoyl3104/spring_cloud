package com.luoyl.eureka_client.service;

import org.springframework.stereotype.Service;

@Service
public class Client1ServiceImpl implements Client1Service {
    @Override
    public String sayHello(String name) {
        return "hello:"+ name;
    }
}
