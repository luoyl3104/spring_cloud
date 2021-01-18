package com.luoyl.eureka_customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String username;
    private String password;

    /**
     *用户对应的角色集合
     */
    private List<Role> roles;


}
