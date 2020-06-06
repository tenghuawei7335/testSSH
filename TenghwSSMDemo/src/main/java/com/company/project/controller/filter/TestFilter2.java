package com.company.project.controller.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.controller.filter
 * @ClassName: TestFilter2
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/23 0023 12:38
 * @Day: 星期六
 */
public class TestFilter2 implements Filter {
    public static FilterConfig filterConfig2=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        TestFilter2.filterConfig2=filterConfig;
        String singer1 = filterConfig2.getInitParameter("singer");
        System.out.println("TestFilter1初始化loading..."+singer1);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TestFilter2执行chain.doFilter(req,resp)之前...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("TestFilter2执行chain.doFilter(req,resp)之后...");
    }

    @Override
    public void destroy() {
        System.out.println("TestFilter2销毁...");
    }
}
