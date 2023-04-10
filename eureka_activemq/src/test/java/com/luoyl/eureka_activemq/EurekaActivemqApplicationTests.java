package com.luoyl.eureka_activemq;

import com.luoyl.eureka_activemq.entity.MqMsg;
import com.luoyl.eureka_activemq.producter.QueueProducer;
import com.luoyl.eureka_activemq.util.MqUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaActivemqApplicationTests {

    @Autowired
    private QueueProducer queueProducer;
    @Autowired
    private MqUtil mqUtil;

    @Test
    void contextLoads() {
        MqMsg mqMsg = new MqMsg();
        mqMsg.setUsername("aa");
        mqMsg.setAge(18);
        queueProducer.sendQueue(mqUtil.sendMqMsg(mqMsg));
    }

}
