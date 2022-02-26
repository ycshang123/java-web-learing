package com.ycshang.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description: Request对象获取请求头数据:user-agent
 * @author: ycshang
 * @create: 2022-02-26 20:28
 **/
@WebServlet(urlPatterns = "/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:referer
        String referer = request.getHeader("referer");
        System.out.println(referer);
        //防盗链
        if (referer != null) {
            if (referer.contains("/")) {
                //正常访问
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影....");
            } else {
                //盗链
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看电影吗？来优酷吧...");
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}