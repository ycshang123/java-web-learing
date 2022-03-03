package com.ycshang.web.exercise.web;

import com.alibaba.fastjson.JSON;
import com.ycshang.web.exercise.entity.Brand;
import com.ycshang.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-03-03 10:34
 **/
@WebServlet(urlPatterns = "/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   调用Service查询
        List<Brand> brands = brandService.selectAll();
        //    将集合转换为JSON数据
        String jsonString = JSON.toJSONString(brands);
        //    响应数据
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}