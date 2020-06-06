package com.company.project.controller;


import com.company.project.pojo.Student;
import com.company.project.service.IStudentService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.controller
 * @ClassName: StudentConyroller
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/19 0019 02:23
 * @Day: 星期二
 */
@Controller
@RequestMapping(value = {"test"})
public class StudentController {
    private  final  static Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Value("${dbcp.password:0000}")
    private  volatile  String maybethw;
    @Value("#{studentServiceImp.HOBBY?:null}")
    private  volatile  String hobby;
    @Resource(name = "studentServiceImp")
    IStudentService iStudentService;

/** 
* @Description:  
* @Author: tenghw
* @Date: 2020/5/25 0025 
* @Param:  
* @return:  
*/
    @RequestMapping(value = "getName",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getName(@RequestParam int id){
      logger.info("请求参数id======="+id);
      logger.debug("@Value(${})======"+maybethw);
      logger.debug("@Value(#{})======"+hobby);
      return iStudentService.getServiceName(id);
    }
/** 
* @Description:  
* @Author: tenghw
* @Date: 2020/5/25 0025 
* @Param:  
* @return:  
*/
    @RequestMapping(value = "getList",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String getList(Model model) throws SQLException {
        List<Map<String, Object>> list = iStudentService.getList();
        logger.info("studentList======="+list);
        model.addAttribute("studentList", list);
        return "student";
    }
/** 
* @Description:  
* @Author: tenghw
* @Date: 2020/5/25 0025 
* @Param:  
* @return:  
*/
    @RequestMapping(value = "insertInto",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void insertInto(int id,String name,String address,int classid){
        Student student = new Student(id, name, address, classid);
        iStudentService.insertStu(student);

    }
/** 
* @Description:  
* @Author: tenghw
* @Date: 2020/5/25 0025 
* @Param:  
* @return:  
*/
    @RequestMapping(value = "getAll",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getAll(Model model,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam(value = "pageNum",required = false,defaultValue = "1") int page,
                         @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize)
                         throws SQLException, IOException {

        List<Student> studentAll = iStudentService.findPage(page, pageSize);
        PageInfo<Student> pageInfo=new PageInfo<Student>(studentAll);
        model.addAttribute("pageInfo",pageInfo);
        return "studentOne";
    }

    @RequestMapping(value = "insertInto1",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void insertInto(@RequestParam(value ="id1",required = false,defaultValue = "id1isnull") String id1,
                           @RequestParam(value = "name1",required = false,defaultValue = "name1isnull") String name1,
                           @RequestParam(value = "address1",required = false,defaultValue = "address1isnull") String address1,
                           @RequestParam(value = "classid1",required = false,defaultValue = "classid1isnull") String classid1,

                           @RequestParam(value ="id2",required = false,defaultValue = "id1isnull") String id2,
                           @RequestParam(value = "name2",required = false,defaultValue = "name2isnull") String name2,
                           @RequestParam(value = "address2",required = false,defaultValue = "address2isnull") String address2,
                           @RequestParam(value = "classid2",required = false,defaultValue = "classid2isnull") String classid2
    ){
        System.out.println("id1="+id1+","+"name1="+name1+","+"address1="+address1+","+"classid1="+classid1);
        System.out.println("id2="+id2+","+"name2="+name2+","+"address2="+address2+","+"classid2="+classid2);

//        System.exit(1);
//
//        Student student = new Student();
//        iStudentService.insertStu(student);

    }

/**
* @Description:
* @Author: tenghw
* @Date: 2020/5/26 0026
* @Param: JSON字符串
* @return:
*/
    @RequestMapping(value = "insertJSON",method = RequestMethod.POST,produces = "text/html;charset=UTF-8",consumes = "application/json")
    @ResponseBody
    public Student insertJSON(@RequestBody String jsonObject){
       // {"id":"36","name":"曹丕","address":"许昌","classid":"1"}
       System.out.println(jsonObject);

       Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Student student1 = gson.fromJson(jsonObject, Student.class);
       // Student(id=36, name=曹丕, address=许昌, classid=1)
        System.out.println(student1);

        iStudentService.insertStu(student1);
        return  student1;
    }

    @RequestMapping(value = "insertJSON1",method = RequestMethod.POST,produces = "text/html;charset=UTF-8",consumes = "application/json")
    @ResponseBody
    public Student  insertJSON1(@RequestBody Student student){

        System.out.println(student);
        iStudentService.insertStu(student);
        return  student;


    }

    @RequestMapping(value = "insertJSON2",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Student  insertJSON2(Student student,String id,String name){
      //insertJSON2===Student(id=88, name=alice, address=纽约, classid=1),,,id,name88alice
        System.out.println("insertJSON2==="+student+",,,id,name"+id+name);
        iStudentService.insertStu(student);
        return  student;


    }
}
