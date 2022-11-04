package com.niuerboy.service.impl;

import com.niuerboy.bean.Student;
import com.niuerboy.utils.RandomNameUtils;
import com.niuerboy.dao.StudentJpaRepository;
import com.niuerboy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @AUTHOR : liuwei
 * @DATE : 2022/11/4 1:01
 * @DESCRIPTION :
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Override
    public void InitStudent() {
       studentJpaRepository.saveAll(getStudentList());
    }

    @Override
    public List<Student> findBySchoolClass(int classno) {
        return studentJpaRepository.findBySchoolClass(classno);
    }

    public List<Student> getStudentList(){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            students.add(new Student(null, RandomNameUtils.fullName(),15+new Random().nextInt(5),
                    new Timestamp(System.currentTimeMillis()),RandomNameUtils.getProCity(),new Random().nextInt(8)+1));
        }
        return students;
    }
}
