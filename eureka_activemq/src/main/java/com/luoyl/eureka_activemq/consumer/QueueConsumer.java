package com.luoyl.eureka_activemq.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {


    @JmsListener(destination = "${queue}")
    public void consumer(String msg){
        try{
            if (!StringUtils.isEmpty(msg)){
                System.out.println("消息体"+msg);
                JSONObject jsonObject = JSONObject.parseObject(msg);
                Boolean sex = jsonObject.getBoolean("sex");
                System.out.println(sex);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
