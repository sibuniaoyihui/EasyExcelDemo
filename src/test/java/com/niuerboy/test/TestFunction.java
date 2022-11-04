package com.niuerboy.test;

import com.niuerboy.bean.ClassEnum;
import com.niuerboy.bean.Student;
import com.niuerboy.utils.RandomNameUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @AUTHOR : liuwei
 * @DATE : 2022/11/4 1:19
 * @DESCRIPTION :
 */
public class TestFunction {

    @Test
    public void Test1(){
        System.out.println(ClassEnum.valueOf("Two"));
    }
    public List<Student> getStudentList(){
        List<Student> students = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            students.add(new Student(null, RandomNameUtils.fullName(),15+new Random().nextInt(5),
                    new Timestamp(System.currentTimeMillis()),RandomNameUtils.getProCity(),
                    new Random().nextInt(8)+1));
        }

        return students;
    }
}
