package com.ycshang.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description: 获取Session对象，存储数据
 * @author: ycshang
 * @create: 2022-02-28 13:53
 **/
@WebServlet("/demo1")
@Slf4j
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   获取Session对象
        HttpSession session = req.getSession();
        //    打印session
        log.info(String.valueOf(session));
        //存储数据
        session.setAttribute("username", "张三");
        session.invalidate();
        log.info(String.valueOf(session.getAttribute("username")));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}