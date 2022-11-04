package com.niuerboy.service;

import com.niuerboy.bean.Student;


import java.util.List;

/**
 * @AUTHOR : liuwei
 * @DATE : 2022/11/4 0:59
 * @DESCRIPTION :
 */

public interface StudentService {

    /**
     * 初始化，产生学生信息数据
     */
    void InitStudent() throws Exception;

    /**
     * 根据班级查询学生信息
     * @return
     */
    List<Student> findBySchoolClass(int classno) throws Exception;
}
