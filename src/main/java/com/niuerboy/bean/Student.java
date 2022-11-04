package com.niuerboy.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.niuerboy.utils.TimestampStringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @AUTHOR : liuwei
 * @DATE : 2022/11/4 0:46
 * @DESCRIPTION :
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {

    /**
     * 主键id也是序号，由于数据库序号设置的自增
     */
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    private String username;

    private int age;

    /**
     * 入学时间，设置java.sql.Timestamp类型，便于后面自定义Convert类时对格式进行转换
     */
//    @ExcelProperty(value = "入学时间", converter = TimestampStringConverter.class)
    private Timestamp attendtime;

    private String address;

    private int schoolclass;

}
