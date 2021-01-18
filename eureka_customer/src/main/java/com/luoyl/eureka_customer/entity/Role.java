package com.luoyl.eureka_customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private String id;
    private String roleName;

    /**
     * 角色对应权限集合
     */
    private List<Permissions> permissions;

}
