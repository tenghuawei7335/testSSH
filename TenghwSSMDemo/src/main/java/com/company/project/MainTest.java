package com.company.project;

import com.company.project.pojo.Student;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: pojo
 * @ClassName: Demo
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/19 0019 00:49
 * @Day: 星期二
 */
public class MainTest {
    public static final ObjectMapper om=new ObjectMapper();

    public static void main(String[] args) throws IOException {
        Student student=new Student(1, "滕华伟", "江苏南京", 1);
        /**pojo对象、json字符串互相转换*/

        //om转换为格式化的json
        om.enable(SerializationFeature.INDENT_OUTPUT);
       //json如果有字段，pojo没有，不报错。(不管是pojo转JSON,还是JSON转pojo)
       om.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);

       //写入文件中
        om.writeValue(new File("F:"+File.separatorChar+"test.txt"), student);

       //pojo➜JSON字符串类型
        String stringJSON = om.writeValueAsString(student);
        System.out.println("stringJSON==="+stringJSON);
        //JSON字符串➜pojo
        Student student1 =om.readValue(stringJSON, Student.class);
        System.out.println(student1);



       //pojo对象➜bytes数组(字节值形式的数组)
        byte[] bytesStudent = om.writeValueAsBytes(student);
        //bytes数组➜pojo
        Student student2 = om.readValue(bytesStudent, Student.class);
        System.out.println("student2==="+student2);

        //map➜pojo对象(map的key一定和pojo的属性名一致！)
        Map  map1=new HashMap();
        map1.put("id", "9527");
        map1.put("name", "刘邦");
        map1.put("address","江苏徐州" );
        map1.put("classid", 1);
       // map1.put("sex", "男");//多出字段或者key与pojo属性值不一致，都会报错！
        Student student3 = om.convertValue(map1, Student.class);
        System.out.println("student3==="+student3);

        //map➜JSON字符串
        String stringJSON1 = om.writeValueAsString(map1);
        System.out.println("stringJSON1==="+stringJSON1);
        //JSON字符串➜map
     Map map = om.readValue(stringJSON1, Map.class);
     System.out.println("map==="+map+","+map.getClass());

     //=======================GSON工具类下pojo和json字符串互转=====================
     Gson gson=new Gson();
     Student student5 = gson.fromJson(stringJSON1, Student.class);
     System.out.println("studen5==="+student5);

     String stringJSON2 = gson.toJson(student5);
     System.out.println("stringJSON2==="+stringJSON2);
     //==============


     //GSON中JsonObject、JsonArray
     JsonObject jsonObject=new JsonObject();
     jsonObject.addProperty("age", 28);
     jsonObject.addProperty("hobby", "跑步");
     System.out.println(jsonObject+","+jsonObject.getClass());//{"age":28,"hobby":"跑步"},class com.google.gson.JsonObject

     JsonArray jsonElements=new JsonArray();
     jsonElements.add("游泳");
     jsonElements.add("篮球");
     System.out.println(jsonElements+","+jsonElements.getClass());//["游泳","篮球"],class com.google.gson.JsonArray

     //jsonObject内嵌jsonArray
     jsonObject.add("课外项目", jsonElements);
     System.out.println(jsonObject);//{"age":28,"hobby":"跑步","课外项目":["游泳","篮球"]}
     //jsonObject内嵌子元素jsonElement---jsonObject1
     JsonObject jsonObject1=new JsonObject();
     jsonObject1.addProperty("city", "江苏南京");
     System.out.println("hobby===="+jsonObject.get("hobby").getAsString());
     jsonObject.add("son1===", jsonObject1);
     System.out.println(jsonObject);
     //数组，list,map
     JsonObject jsonObject2 = (JsonObject) new JsonParser().parse("{'id':'1','name':'zs'}");
     System.out.println(jsonObject2);//{"id":"1","name":"zs"}


//       File file=new File(MainTest.class.getResource("/myJson.json").getFile());
//     String s = FileUtils.readFileToString(file, "UTF-8");
//     JSONObject jsonObject1=new JSONObject(s);
//     System.out.println(jsonObject1.getString("name"));


    }
}
