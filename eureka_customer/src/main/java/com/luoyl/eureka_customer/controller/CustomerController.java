package com.luoyl.eureka_customer.controller;

import com.luoyl.eureka_customer.config.RestTemplateConfig;
import com.luoyl.eureka_customer.feign.Client1Feign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private Client1Feign client1Feign;

    @Autowired
    private RestTemplateConfig restTemplate;

    @RequestMapping("test")
    public String test(){
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8088/client1/test1", String.class);
        return forObject;
    }

    @RequestMapping(value = "restTemplate",method = RequestMethod.GET)
    public String testRestTemplate(String name){
        HashMap<String, Object> requestMap = new HashMap<>();
        requestMap.put("name",name);
        return restTemplate.getRestTemplate().getForObject("http://localhost:8088/client1/hello?name={name}",String.class,requestMap);
    }

    @HystrixCommand(fallbackMethod = "testFallback")
    @RequestMapping(value = "feign",method = RequestMethod.GET)
    public String testFeign(String name){
        return client1Feign.sayHello(name);
    }

    public String testFallback(String name){
        return "错误处理，参数:"+name;
    }
}
