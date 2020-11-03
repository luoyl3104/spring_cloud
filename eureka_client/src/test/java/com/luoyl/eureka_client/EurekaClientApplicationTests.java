package com.luoyl.eureka_client;

import com.luoyl.eureka_client.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaClientApplicationTests {

    @Test
    void contextLoads() {
        TUser tUser = new TUser();
        tUser.setAge(18);
        tUser.setName("花花");
        System.out.println(tUser.toString());
    }

}
