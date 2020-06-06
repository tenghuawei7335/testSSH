package com.company.project.mapper;

import com.company.project.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.mapper
 * @ClassName: IStudent
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/19 0019 02:09
 * @Day: 星期二
 */
public interface IStudentMapper {
    public  String  getName(@Param("id") int id);
    public void insertStudent(@Param("student") Student student);
    public List<Student> getStudents();
}
