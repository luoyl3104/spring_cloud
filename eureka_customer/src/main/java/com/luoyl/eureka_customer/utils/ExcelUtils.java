package com.luoyl.eureka_customer.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class ExcelUtils {


    public static <T> void excelExport(List<T> list,Class<T> pojoClass,String fileName) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        String upperCase = request.getHeader("User-Agent").toUpperCase();
        //IE浏览器
        if (upperCase.contains("MSIE") || upperCase.contains("TRIDENT") || upperCase.contains("EDGE")){
            fileName = URLEncoder.encode(fileName,"UTF-8");
        }else {//其他浏览器
            fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
        }
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xls");
        HSSFWorkbook workbook = (HSSFWorkbook) ExcelExportUtil.exportExcel(new ExportParams(null, fileName), pojoClass, list);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }

}
