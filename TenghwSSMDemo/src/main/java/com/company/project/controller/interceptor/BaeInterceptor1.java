package com.company.project.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.controller.interceptor
 * @ClassName: TestInterceptor1
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/23 0023 15:44
 * @Day: 星期六
 */

/**每次方法耗时拦截器统计和警告
 * @author ZARD*/
public class BaeInterceptor1 implements HandlerInterceptor {
    /**前置处理*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //记录请求日志
        System.out.println("BaeInterceptor1拦截器：前置处理-请求日志---"+request.getRequestURI());
        //返回true，才会找下一个拦截器，如果没有下一个拦截器，则去Controller
        return true;

    }
    /**后置处理*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("BaeInterceptor1拦截器：后置处理-请求日志---"+request.getRequestURI());

    }
    /**完成处理*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("BaeInterceptor1拦截器：完成处理-请求日志---"+request.getRequestURI());
    }
}
