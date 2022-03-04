package com.ycshang.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-04 14:04
 **/
@WebServlet(urlPatterns = "/wordsServlet")
public class WordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String words = request.getParameter("words");
        System.out.println("发布内容：" + words);
        PrintWriter out = response.getWriter();
        out.write(words);
        out.close();
    }
}
