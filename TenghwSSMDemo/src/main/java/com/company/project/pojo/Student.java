package com.company.project.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.pojos
 * @ClassName: Student
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/19 0019 10:20
 * @Day: 星期二
 */
@Data
@Builder
public class Student {
    private int id;
    private String name;
    private String address;
    private int classid;
public  Student(){

}
    public Student(int id, String name, String address, int classid) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classid = classid;
    }
}
