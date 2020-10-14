package com.luoyl.client2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client2")
public class Client2Test {

    @RequestMapping("test2")
    public String client2Test(){
        return "this is client2Test";
    }
}
