package com.luoyl.eureka_client.service.impl;

import com.luoyl.eureka_client.service.HdfsService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.print.URIException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class HdfsServiceImpl implements HdfsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${hdfs_path}")
    private String HDFS_PATH;

    @Value("{dirPath}")
    private String hDirPath;//hdfs文件夹路径

    FileSystem fileSystem = null;
    Configuration configuration = null;

    /**
     *
     * @param filePath 文件上传至服务器路径
     * @return
     */
    @Override
    public String fileUpload(String filePath) {
        configuration = new Configuration();
        try {
            fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration);
        }catch (Exception e){
            logger.error("获取fileSystem失败");
            e.printStackTrace();
        }
        try {
            fileSystem.copyFromLocalFile(new Path(filePath), new Path(hDirPath));
        }catch (Exception e){
            logger.error("文件上传至hdfs失败");
            e.printStackTrace();
        }
        configuration = null;
        fileSystem = null;
        return "上传成功！";
    }
}
