package com.ycshang.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @program: java-web-learning
 * @description: Request对象获取请求头
 * @author: ycshang
 * @create: 2022-02-26 20:26
 **/
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求头数据
        //1.获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //2.遍历
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name + "---" + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


    }
}
