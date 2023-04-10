package com.luoyl.eureka_client;

import com.luoyl.eureka_client.entity.TUser;
import org.apache.commons.io.FilenameUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.WeakHashMap;

@SpringBootTest
class EurekaClientApplicationTests {


    public static void main(String[] args) {
        String HDFS_PATH = "hdfs://192.168.138.135:9000";
        FileSystem fileSystem=null;
        Configuration configuration = null;

        try{
            configuration = new Configuration();
            fileSystem = FileSystem.get(new URI(HDFS_PATH),configuration,"root");
            fileSystem.copyFromLocalFile(new Path("C:/Users/luoyulong/Desktop/user.xlsx"),new Path("test"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fileSystem = null;
            configuration = null;
        }
    }


    @Test
    void contextLoads() {
        TUser tUser = new TUser();
        tUser.setAge(18);
        tUser.setName("花花");
        System.out.println(tUser.toString());

    }

    @Test
    void testName(){
        String fileName = "abcd.aMD";
        boolean md = fileName.toLowerCase().endsWith("md");
        System.out.println(md);
        String extension = FilenameUtils.getExtension(fileName.toLowerCase());
        System.out.println(extension);
    }


    @Test
    public void test(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFiles");
        System.out.println(realPath);
    }

}
