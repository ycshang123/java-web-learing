package com.ycshang.web.response.servletcontext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: 03-Servlet
 * @description: 两种方法获得servletContext对象
 * ServletContext的功能
 * 1、获取MIME类型
 * 2、共享数据
 * 3、获取服务器真实路径
 * @author: ycshang
 * @create: 2022-02-25 16:19
 **/
@WebServlet("/context")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   1、通过request对象获取
        ServletContext sc1 = req.getServletContext();
        //2、通过当前的Servlet对象获取
        ServletContext sc2 = this.getServletContext();
        System.out.println("114433");
        System.out.println(sc1 == sc2);
    }
}