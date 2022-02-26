package com.ycshang.web.response.servletcontext;


import com.ycshang.web.response.domain.Person;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: 03-Servlet
 * @description: 通过Servlet共享数据
 * @author: ycshang
 * @create: 2022-02-25 16:19
 **/
@WebServlet("/context3")
public class ServletContextDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        //sc.setAttribute("data","hello word");
        Person person = new Person("小李","男","123456");
        sc.setAttribute("data",person.toString());
        resp.sendRedirect("/responseDemo2");

    }
}