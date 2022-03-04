package com.ycshang.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-03-04 08:30
 **/
//@WebFilter(urlPatterns = "/*")
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器2初始化");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器2销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("过滤器2被执行……");
        System.out.println("444444444444444444");
        //    放行,让请求访问其本该访问的资源
        filterChain.doFilter(servletRequest, servletResponse);
        //System.out.println("返回过滤器2");
        System.out.println("5555555555555555555");
    }
}