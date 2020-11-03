package com.luoyl.eureka_client.controller;

import com.luoyl.eureka_client.entity.TUser;
import com.luoyl.eureka_client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("queryAll")
    public List<TUser> queryAll(){
        return userService.findAll();
    }

}
