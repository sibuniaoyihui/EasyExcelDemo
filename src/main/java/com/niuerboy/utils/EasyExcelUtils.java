package com.niuerboy.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.converters.ConverterKeyBuild;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.niuerboy.bean.Student;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @AUTHOR : liuwei
 * @DATE : 2022/11/2 23:18
 * @DESCRIPTION :
 */

@Slf4j
public class EasyExcelUtils {

    /**
     * 设置web响应输出的文件名称
     * @param response web响应
     * @param fileName 导出文件名称
     */
    private static void setResponseHeader(HttpServletResponse response, String fileName) {
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" +
                    URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码", e.getLocalizedMessage());
        }
        response.setCharacterEncoding("UTF-8");
    }

    public static void exportStudedntExcel(HttpServletResponse response, HashMap<String,Object> datas,String fileName) throws IOException{


        setResponseHeader(response, fileName);
        //未获取到数据时
        if (datas.get("data") == null){
            return;
        }
        ExcelWriter workbook= null;
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        try{
            String template="student_fill_template.xlsx";

            //日期转化格式字符串
            TimestampStringConverter converter = new TimestampStringConverter();//registerConverter(converter)
            workbook = EasyExcel.write(bos).registerConverter(converter).withTemplate(template).build();

            //workbook.writeContext().currentWriteHolder().converterMap().put(ConverterKeyBuild.buildKey(converter.supportJavaTypeKey()),converter);
            //workbook.writeContext().currentWriteHolder().converterMap().put(ConverterKeyBuild.buildKey(converter.supportJavaTypeKey(), converter.supportExcelTypeKey()),converter);

            WriteSheet sheet = EasyExcel.writerSheet("Sheet1").build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(true).build();

            //填充议题数据
            workbook.fill(datas.get("data"),fillConfig,sheet);

            //datas.remove("data");
            //获取副标题及角标
            HashMap<String,Object> map = new LinkedHashMap<>();
            map.put("schoolclass",datas.get("schoolclass"));
            map.put("exporttime",datas.get("exporttime").toString());
            //填充角标及标题数据
            workbook.fill(map,sheet);
        }catch (Throwable ex){
            log.error("exportMeetExcel",ex.getMessage());
        }finally {
            bos.flush();
            if (workbook != null){
                workbook.finish();
            }
        }
    }


}
