package com.ycshang.web.response.download;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: 03-Servlet
 * @description:
 * @author: ycshang
 * @create: 2022-02-25 14:27
 **/
@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求参数，文件名
        String filename = req.getParameter("filename");
        //    2、使用字节输入流加载文件到内存
        //    2.1、找到文件的服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        //  2.2、使用字节流输入
        InputStream is = new FileInputStream(realPath);
        //   3、设置响应头的打开方式
        resp.setHeader("content-disposition", "attachment;filename" + filename);
        //  4、将输入流中的数据写到输出流(借助缓冲)
        ServletOutputStream sos = resp.getOutputStream();
        //    缓冲区
        byte[] buff = new byte[1024 * 8];
        int len;
        while ((len = is.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        sos.flush();
        sos.close();
        is.close();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


}