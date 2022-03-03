package com.ycshang.web.servlet;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-03-03 13:34
 **/
@WebServlet(urlPatterns = "/login1")
public class LoginServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    通过缓冲流字符流按行读取JSON数据，拼接到可变长字符串
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader bufferedReader = req.getReader();
        while ((line = bufferedReader.readLine()) != null) {
            json.append(line);
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=utf-8");
        //    将字符串转换成JSON对象
        out.println(JSON.parseObject(json.toString()));
        out.flush();
        out.close();
    }
}