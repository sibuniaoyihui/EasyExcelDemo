package com.niuerboy.controller;

import com.niuerboy.bean.ClassEnum;
import com.niuerboy.bean.Student;
import com.niuerboy.service.impl.StudentServiceImpl;
import com.niuerboy.utils.EasyExcelUtils;
import com.niuerboy.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/**
 * @AUTHOR : liuwei
 * @DATE : 2022/11/4 1:48
 * @DESCRIPTION :
 */

@RestController
@Slf4j
public class StudentController {


    @Autowired
    StudentServiceImpl service;

    @Autowired
    HttpServletResponse response;

    /**
     * 初始化数据
     */

    @PostMapping("/init")
    public void initialStudentData(){
        try {
            service.InitStudent();
        }catch (Throwable throwable){
            log.error("initialStudentData--",throwable.getLocalizedMessage());
        }
    }


    @GetMapping("/export/{classno}")
    public void exportStudentInfo(@PathVariable(value = "classno") int classno){
        try {
            List<Student> students = service.findBySchoolClass(classno);
            log.info("查询学生信息结果:",students);
            HashMap<String,Object> datas = new HashMap<>();
            //Excel导出
            datas.put("data",students);
            datas.put("schoolclass", ClassEnum.values()[classno -1].getName());
            datas.put("exporttime",new Timestamp(System.currentTimeMillis()));
            log.info("----------------------开始导出----------------------");
            EasyExcelUtils.exportStudedntExcel(response,datas,ClassEnum.values()[classno -1].getName()+"学生信息表");
        } catch (Exception exception) {
            log.error("exportStudentInfo--",exception.getLocalizedMessage());
        }
    }


}
