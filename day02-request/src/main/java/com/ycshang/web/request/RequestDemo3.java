package com.ycshang.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-02-26 20:28
 **/
@WebServlet(urlPatterns = "/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头数据:user-agent
        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            //谷歌
            System.out.println("谷歌浏览器...");
        } else if (agent.contains("Firefox")) {
            //火狐
            System.out.println("火狐浏览器...");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}