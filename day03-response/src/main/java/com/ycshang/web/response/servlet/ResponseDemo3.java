package com.ycshang.web.response.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: 03-Servlet
 * @description:Response响应练习:向客户端返回字符数据
 * @author: ycshang
 * @create: 2022-02-25 08:41
 **/
@WebServlet(urlPatterns = "/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String info = "JavaWeb开发";
       //resp.setContentType("text/html;charset=utf-8");
       PrintWriter out = resp.getWriter();
       out.println(info);
       out.flush();
       out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}