package com.luoyl.eureka_customer.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class KafkaCustomer {


    @KafkaListener(topics = {"SESSION_ID"})
    public void getValue(ConsumerRecord<?, String> record){
        String str = record.value();
        System.out.println("sessionId="+str);
    }

}
