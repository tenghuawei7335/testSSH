package com.company.project.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.pojo
 * @ClassName: SeeUser
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/29 0029 21:10
 * @Day: 星期五
 */
@Data
@Builder
/**
 * @Description:
 * @Author: tenghw
 * @Date: 2020/5/29 0029
 * @Param:用户id,用户访问的时间,用户访问的次数
 * @return:
 */
public class SeeUser implements Serializable {
    private static final long serialVersionUID = 7379677163828681711L;
    private String id;
    private String ip;
    private String seeTime;
    private int seeCount;
}
