package com.ycshang.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @program: java-web-learning
 * @description: URL编码
 * @author: ycshang
 * @create: 2022-02-28 10:36
 **/
@WebServlet(urlPatterns = "/servletD")
@Slf4j
public class ServletD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getAttribute("name");
        name = URLDecoder.decode(name, StandardCharsets.UTF_8);
        log.info(name);
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().write(name);
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}