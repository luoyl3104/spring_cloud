package com.luoyl.eureka_activemq.entity;

import java.io.Serializable;

/**
 * @author luoyulong
 * @date 2022/6/27
 * @version: 1.0.0
 * @className: MqMsg
 */
public class MqMsg implements Serializable {

    private String username;
    private Boolean sex;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
