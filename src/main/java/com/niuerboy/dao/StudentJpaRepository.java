package com.niuerboy.dao;

import com.niuerboy.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student,Long> {

    /**
     * 根据班级编号进行查询
     * @param classno
     * @return
     */
    @Query(value = "select * from student where schoolclass =?1",nativeQuery = true)
    List<Student> findBySchoolClass(int classno);
}
