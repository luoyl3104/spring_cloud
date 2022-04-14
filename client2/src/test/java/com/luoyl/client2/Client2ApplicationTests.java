package com.luoyl.client2;

import org.apache.maven.shared.invoker.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

//@SpringBootTest
class Client2ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("111");
    }

    @Test
    public void mvnTest(){
        String mvnPath="D:\\maven\\apache-maven-3.6.0";
        String pomPath="D:\\workspace\\spring_cloud\\client2\\pom.xml";
        String mvnOrder="mvn dependency:tree > dependency.txt";
        DefaultInvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File(pomPath));
        request.setGoals(Collections.singletonList(mvnOrder));

        DefaultInvoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(mvnPath));
        invoker.setLogger(new PrintStreamLogger(System.err, InvokerLogger.ERROR){});

        invoker.setOutputHandler(new InvocationOutputHandler() {
            @Override
            public void consumeLine(String s) throws IOException {

            }
        });

        try{
            invoker.execute(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
