package com.luoyl.eureka_client.service;

import com.luoyl.eureka_client.entity.TUser;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

public interface UserService {
    List<TUser> findAll();
    String addList(MultipartFile file);
    String add(InputStream inputStream);
    void export();
}
