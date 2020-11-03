package com.luoyl.eureka_client.service;

import com.luoyl.eureka_client.entity.TUser;

import java.util.List;

public interface UserService {
    List<TUser> findAll();
}
