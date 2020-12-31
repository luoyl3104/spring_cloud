package com.luoyl.eureka_client.controller;

import com.luoyl.eureka_client.service.HdfsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@RequestMapping("file")
@Api(value = "fileController")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HdfsService hdfsService;

    @Value("${realPath}")
    private String path;

    @RequestMapping(value = "fileUpload",method = RequestMethod.POST)
    @ApiOperation("文件上传")
    public String fileUpload(MultipartFile file){

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFiles");
        System.out.println(realPath);
        String filename = file.getOriginalFilename();
        try {
            file.transferTo(new File("D://tmp/",filename));
            /*String s = hdfsService.fileUpload(realPath + filename);
            return s;*/
            return "上传成功";
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败!";
        }

    }



}
