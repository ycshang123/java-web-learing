package com.ycshang.web.response.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: 03-Servlet
 * @description:Response响应练习:设置响应头，重定向
 * @author: ycshang
 * @create: 2022-02-25 08:41
 **/
@WebServlet(urlPatterns = "/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseDemo2 被访问……");
        ServletContext context = req.getServletContext();
        Object data = context.getAttribute("data");
        System.out.println(data);
        //Object msg = req.getAttribute("msg");
        //System.out.println(msg);
        ////    1、设置状态码为302,重定向
        //resp.setStatus(302);
        ////通过request跨域传递数据
        //req.setAttribute("msg", "hello response");
        ////    设置响应头
        //resp.setHeader("location", "/responseDemo2");

    }
}