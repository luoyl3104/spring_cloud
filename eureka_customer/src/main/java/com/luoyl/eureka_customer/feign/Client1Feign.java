package com.luoyl.eureka_customer.feign;

import com.luoyl.eureka_customer.entity.TUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@FeignClient(serviceId = "client1",fallback = FeignClientFallBack.class)
public interface Client1Feign {

    @GetMapping("client1/hello")
    String sayHello(@RequestParam("name") String name);

    @PostMapping("user/queryAll")
    List<TUser> queryAll();

    /*@PostMapping("user/addAll")
    String addAll(@RequestParam("file") MultipartFile file);*/

    /*@PostMapping("user/add")
    String add(InputStream inputStream);*/

}
