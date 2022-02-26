package com.ycshang.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description: 注解方式配置Servlet
 * @author: ycshang
 * @create: 2022-02-26 19:32
 **/
@WebServlet("/demo")
public class ServletDemo implements Servlet {
    /**
     * Servlet初始化
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

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
        System.out.println("Servlet学习……");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * Servlet销毁
     */
    @Override
    public void destroy() {

    }
}