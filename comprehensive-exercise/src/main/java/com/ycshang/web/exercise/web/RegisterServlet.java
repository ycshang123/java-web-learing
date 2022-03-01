package com.ycshang.web.exercise.web;

import com.ycshang.web.exercise.entity.User;
import com.ycshang.web.exercise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-03-01 16:30
 **/
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   获取用户名和密码
        String username = req.getParameter("registerName");
        String password = req.getParameter("registerPassWord");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAvatar("https://cdn.jsdelivr.net/gh/ycshang123/image-hosting@master/7.309m5bf9shq0.jpg");
        String inputCode = req.getParameter("inputCode");
        //程序生成的验证码,从session获取
        HttpSession session = req.getSession();
        String verifyCode = (String) session.getAttribute("verifyCode");
        resp.setContentType("text/html;charset=utf-8");
        String contextPath = req.getContextPath();
        //忽略大小写比对
        if (!verifyCode.equalsIgnoreCase(inputCode)) {
            //    验证码错误，跳回注册页面
            resp.getWriter().write("<script>alert('验证码错误');location='register.html';</script>");
        }
        //    调用注册接口
        boolean flag = userService.register(user);

        if (flag) {
            //注册成功，跳转登陆页面
            resp.getWriter().write("<script>alert('注册成功');location='/login.html';</script>");
        } else {
            //用户名已存在，注册失败，跳回注册页面
            resp.getWriter().write("<script>alert('用户名已存在');location='/login.html';</script>");
        }
    }
}