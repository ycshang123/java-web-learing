package com.ycshang.web.response.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @program: 03-Servlet
 * @description:Response响应练习:向客户端返回字节数据
 * @author: ycshang
 * @create: 2022-02-25 08:41
 **/
@WebServlet(urlPatterns = "/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{\n" +
                "  \"msg\": \"success\",\n" +
                "  \"data\": {\n" +
                "    \"bookName\": \"学习问答\",\n" +
                "    \"cover\": \"http://p2.img.cctvpic.com/photoAlbum/page/performance/img/2021/3/30/1617083963025_537.jpg\"\n" +
                "    \n" +
                "  }\n" +
                "}";
        resp.setContentType("application/json");
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(json.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}