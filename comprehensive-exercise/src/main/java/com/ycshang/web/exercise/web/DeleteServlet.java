package com.ycshang.web.exercise.web;

import com.ycshang.web.exercise.service.BrandService;
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
 * @create: 2022-03-01 17:50
 **/
@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求");
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进去");
        String id = req.getParameter("id");
        System.out.println(id);
        brandService.delete(Integer.parseInt(id));
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/index");


    }
}