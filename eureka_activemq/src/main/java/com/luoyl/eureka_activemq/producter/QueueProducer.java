package com.luoyl.eureka_activemq.producter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Value("${queue}")
    private String queue;

    public void sendQueue(String msg){
        try{
            jmsMessagingTemplate.convertAndSend(queue,msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
