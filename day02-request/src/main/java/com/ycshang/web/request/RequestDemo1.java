package com.ycshang.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description: request对象获取请求行数据
 * @author: ycshang
 * @create: 2022-02-26 20:13
 **/
@WebServlet(urlPatterns = "/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求方式 ：GET
        String method = request.getMethod();
        System.out.println(method);
        //2. 获取虚拟目录：/
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3. 获取Servlet路径: /requestDemo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4. 获取get方式请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5. 获取请求URI：/requestDemo1
        String requestUri = request.getRequestURI();
        StringBuffer requestUrl = request.getRequestURL();
        System.out.println(requestUri);
        System.out.println(requestUrl);
        //6. 获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7. 获取客户机的IP地址：
        String remoteAddress = request.getRemoteAddr();
        System.out.println(remoteAddress);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}