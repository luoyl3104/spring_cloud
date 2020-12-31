package com.luoyl.eureka_client.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.luoyl.eureka_client.dao.TUserMapper;
import com.luoyl.eureka_client.entity.TUser;
import com.luoyl.eureka_client.service.UserService;
import com.luoyl.eureka_client.util.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TUserMapper tUserMapper;


    @Override
    public List<TUser> findAll() {
        return tUserMapper.selectAll();
    }

    @Override
    public String addList(MultipartFile file) {
        logger.debug("文件名："+file.getOriginalFilename());
        try {
            List<TUser> users = ExcelUtils.excelImport(file, 0, 1, TUser.class);
            try {
                tUserMapper.insertList(users);
                return "导入成功！";
            }catch (Exception e){
                e.printStackTrace();
                return "导入失败！";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "easyPoi获取集合失败！";
        }
    }

    @Override
    public String add(InputStream inputStream) {
        try{
            List<TUser> list = ExcelImportUtil.importExcel(inputStream, TUser.class, new ImportParams());
            logger.debug("list.size()="+list.size());
            return "获取成功";
        }catch (Exception e){
            e.printStackTrace();
            return "获取失败";
        }
    }

    @Override
    public void export() {
        List<TUser> tUsers = tUserMapper.selectAll();
        tUsers.stream().forEach(tUser -> System.out.println(tUser));
        try{
            ExcelUtils.excelExport(tUsers,TUser.class,"user");
            logger.info("success");
        }catch (Exception e){
            logger.error("error");
            e.printStackTrace();
        }

    }


}
