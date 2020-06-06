package com.company.project.service.imp;

import com.alibaba.druid.pool.DruidDataSource;
import com.company.project.mapper.IStudentMapper;
import com.company.project.pojo.Student;
import com.company.project.service.IStudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.service.imp
 * @ClassName: StudentServiceImp
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/19 0019 02:31
 * @Day: 星期二
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = Exception.class)
public class StudentServiceImp implements IStudentService  {

    @Resource(name= "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private IStudentMapper iStudentMapper;
//    @Resource(name = "dataSourceC3P0")
//    private ComboPooledDataSource comboPooledDataSource;
    @Resource(name = "dataSourceDruid")
    private DruidDataSource druidDataSource;
    @Override
    public String getServiceName(int id) {
        return iStudentMapper.getName(id);
    }

    @Override
    public List<Map<String, Object>> getList() throws SQLException {
        List<Map<String, Object>> list= jdbcTemplate.queryForList("select * from student");
        DataSource dataSource = jdbcTemplate.getDataSource();
        System.out.println(dataSource.getClass()+"--------------");
        //System.out.println(comboPooledDataSource.getIdleConnectionTestPeriod()+"-----***"+comboPooledDataSource.getAcquireIncrement());
        System.out.println(druidDataSource.getClass()+"----druid---"+druidDataSource.getMaxActive());
        return list;
    }

    @Override
    public void insertStu(Student student) {
       iStudentMapper.insertStudent(student);
    }

    @Override
    public List<Student> findPage(int page, int pageSize) {
        //PageHelper.startPage(pageNum, pageSize);这句非常重要，
        // 这段代码表示，程序开始分页了，page默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录
        PageHelper.startPage(page, pageSize);
        List<Student> students = iStudentMapper.getStudents();
        return students;
    }


}
