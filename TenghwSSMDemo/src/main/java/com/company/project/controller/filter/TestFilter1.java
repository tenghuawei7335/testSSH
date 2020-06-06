package com.company.project.controller.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.controller.filter
 * @ClassName: TestFilter1
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/23 0023 12:36
 * @Day: 星期六
 */
public class TestFilter1 implements Filter {
    public static FilterConfig filterConfig1=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        TestFilter1.filterConfig1=filterConfig;
        String singer1 = filterConfig1.getInitParameter("singer");
        System.out.println("TestFilter1初始化loading..."+singer1);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("TestFilter1执行chain.doFilter(req,resp)之前...");
    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("TestFilter1执行chain.doFilter(req,resp)之后...");
    }

    @Override
    public void destroy() {
        System.out.println("TestFilter1销毁...");
    }
}
