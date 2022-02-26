package com.ycshang.web.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description: Servlet接口中的各个方法
 * @author: ycshang
 * @create: 2022-02-26 19:32
 **/
public class ServletDemo2 implements Servlet {
    private static int age = 3;

    /**
     * Servlet初始化
     * 在Servlet被创建时执行，只会执行一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init……");
    }

    /**
     * 获得Servlet配置信息
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     *
     * @param servletRequest  请求对象
     * @param servletResponse 响应对象
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行service");
        age++;
        System.out.println(age + "岁");
    }

    /**
     * 获取servlet的一些信息
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * Servlet销毁
     * 在服务器正常关闭时执行，只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy……");
    }
}