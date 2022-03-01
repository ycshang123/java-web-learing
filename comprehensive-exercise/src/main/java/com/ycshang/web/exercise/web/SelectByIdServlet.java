package com.ycshang.web.exercise.web;

import com.ycshang.web.exercise.entity.Brand;
import com.ycshang.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-03-01 17:08
 **/
@WebServlet(urlPatterns = "/selectById")
@Slf4j
public class SelectByIdServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
        Brand brand = brandService.selectById(Integer.parseInt(id));
        req.setAttribute("brand",brand);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }
}