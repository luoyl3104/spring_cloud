package com.luoyl.eureka_customer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component
public class KafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendSessionId(String sessionId){
        logger.info("sessionId为:"+sessionId);
        //发送消息
        kafkaTemplate.send("SESSION_ID",sessionId);

    }





}
