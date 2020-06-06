package com.company.project.service;

import com.company.project.pojo.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.service
 * @ClassName: IStudentService
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/19 0019 02:30
 * @Day: 星期二
 */
public interface IStudentService {
    public String HOBBY="listento------ZARD";
    public  String  getServiceName(int id);

    public List<Map<String,Object>> getList() throws SQLException;
    public void insertStu(Student student);
   /**
   * @Description:
   * @Author: tenghw
   * @Date: 2020/5/23 0023
   * @Param: page当前页码，pageSize每页查询条数
   * @return:
   */
   public List<Student> findPage(int page,int pageSize);
}
