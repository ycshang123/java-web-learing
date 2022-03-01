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
 * @create: 2022-03-01 16:49
 **/
@WebServlet(urlPatterns = "/addBrand")
@Slf4j
public class AddBrandServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //收集表单提交数据
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        Brand brand = Brand.builder().brandName(brandName).companyName(companyName).ordered(Integer.parseInt(ordered)).description(description).status(Integer.parseInt(status)).build();
        brandService.add(brand);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/index");
    }
}