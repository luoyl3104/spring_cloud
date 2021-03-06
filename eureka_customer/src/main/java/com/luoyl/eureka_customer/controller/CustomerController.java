package com.luoyl.eureka_customer.controller;

import com.luoyl.eureka_customer.config.RestTemplateConfig;
import com.luoyl.eureka_customer.entity.TUser;
import com.luoyl.eureka_customer.feign.Client1Feign;
import com.luoyl.eureka_customer.kafka.KafkaCustomer;
import com.luoyl.eureka_customer.kafka.KafkaProducer;
import com.luoyl.eureka_customer.utils.ExcelUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import io.swagger.annotations.Api;
import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@Api(value = "CustomerController")
@RequestMapping("customer")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private Client1Feign client1Feign;

    @Autowired
    private RestTemplateConfig restTemplate;

    //@Autowired
    //private KafkaProducer kafkaProducer;



    @RequestMapping(value = "test",method = RequestMethod.POST)
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

    /*@GetMapping("/sessionShare")
    public String testSessionShare(HttpServletRequest request){
        HttpSession session = request.getSession();
        //session.getSessionContext().getSession(session.getId());
        kafkaProducer.sendSessionId(session.getId());
        return session.getId();
    }*/

    @PostMapping("getClient1TUser")
    public List<TUser> getClient1TUser(){
        //List<TUser> tUsers = client1Feign.queryAll();
        return client1Feign.queryAll();
    }

    /*@PostMapping("testAdd")
    public String testAdd(MultipartFile file){
        try{
            logger.debug("--------------");
            return client1Feign.add(file.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }*/

    @GetMapping("export")
    public void export(){
        List<TUser> list = client1Feign.export();

        try {
            if (!list.isEmpty()) {
                ExcelUtils.excelExport(list, TUser.class, "users");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
