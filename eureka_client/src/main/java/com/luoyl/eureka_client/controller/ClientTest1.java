package com.luoyl.eureka_client.controller;

import com.luoyl.eureka_client.service.Client1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client1")
public class ClientTest1 {

    @Autowired
    private Client1Service client1Service;

    @GetMapping("test1")
    public String test1(){
        return "this is client1 test";
    }

    @GetMapping("hello")
    public String hello(String name){
        return client1Service.sayHello(name);
    }

}
