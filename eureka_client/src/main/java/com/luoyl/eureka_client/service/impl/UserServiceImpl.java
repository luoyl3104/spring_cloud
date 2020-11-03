package com.luoyl.eureka_client.service.impl;

import com.luoyl.eureka_client.dao.TUserMapper;
import com.luoyl.eureka_client.entity.TUser;
import com.luoyl.eureka_client.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper tUserMapper;


    @Override
    public List<TUser> findAll() {
        return tUserMapper.selectAll();
    }
}
