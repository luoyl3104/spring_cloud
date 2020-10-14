package com.luoyl.eureka_customer.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public String hello(String name) {
        return "customer hello:" + name;
    }
}
