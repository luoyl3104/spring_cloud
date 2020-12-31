package com.luoyl.eureka_client.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void fileUpload(MultipartFile file) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFiles");

        System.out.println(realPath);

        //文件名
        String filename = file.getOriginalFilename();
        //文件类型
        String extension = FilenameUtils.getExtension(filename);

        file.transferTo(new File(realPath,filename));


    }

}
