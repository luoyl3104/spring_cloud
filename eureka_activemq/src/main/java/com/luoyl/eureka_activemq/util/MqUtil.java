package com.luoyl.eureka_activemq.util;

import com.alibaba.fastjson.JSONObject;
import com.luoyl.eureka_activemq.entity.MqMsg;
import org.springframework.stereotype.Component;

/**
 * @author luoyulong
 * @date 2022/6/27
 * @version: 1.0.0
 * @className: MqUtil
 */
@Component
public class MqUtil {


    public String sendMqMsg(MqMsg mqMsg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",mqMsg.getUsername());
        jsonObject.put("sex",mqMsg.getSex());
        jsonObject.put("age",mqMsg.getAge());
        return jsonObject.toJSONString();
    }

}
