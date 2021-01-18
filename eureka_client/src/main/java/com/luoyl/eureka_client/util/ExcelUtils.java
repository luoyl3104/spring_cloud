package com.luoyl.eureka_client.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ExcelUtils {

    public static <T> List<T> excelImport(MultipartFile file,Integer titleRows,Integer headRows,Class<T> pojoClass) throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(titleRows);//表格标题行数，默认0
        importParams.setHeadRows(headRows);//表头行数，默认1
        List<T> list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, importParams);
        return list;
    }


}
