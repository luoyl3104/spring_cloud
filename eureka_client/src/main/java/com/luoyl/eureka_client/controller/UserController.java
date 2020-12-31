package com.luoyl.eureka_client.controller;

import com.luoyl.eureka_client.entity.TUser;
import com.luoyl.eureka_client.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("user")
@Api(value = "UserController",tags = "clientUserController")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("queryAll")
    @ApiOperation(value = "queryAll")
    public List<TUser> queryAll(){
        return userService.findAll();
    }

    @PostMapping("addAll")
    @ApiOperation(value = "addAll")
    public String addAll(MultipartFile file){
        return userService.addList(file);
    }

    @PostMapping("add")
    @ApiOperation(value = "add")
    public String add(InputStream inputStream){
        return userService.add(inputStream);
    }

    @GetMapping("export")
    @ApiOperation(value = "export")
    public void export(){
        userService.export();
    }



}
