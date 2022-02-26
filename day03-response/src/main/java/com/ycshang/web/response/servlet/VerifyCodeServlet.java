package com.ycshang.web.response.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @program: 03-Servlet
 * @description:
 * @author: ycshang
 * @create: 2022-02-25 14:27
 **/
@WebServlet(urlPatterns = "/code")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义验证码图片的大小
        int width = 160;
        int height = 45;
        // 创建一在内存中存放验证码图片的对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 绘制图片
        // 画笔对象
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // 绘制边框
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, width - 1, height - 1);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //    随机生成下标
        Random random = new Random();
        //    四位验证码
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            char ch = str.charAt(index);
            Font font = new Font("Dialog", Font.ITALIC, 20);
            g.setFont(font);
            g.drawString(String.valueOf(ch), width / 5 * i, height/2);
        }
        //    todo：绘制干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 8; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        //    验证码输出到页面
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


}