package com.ycshang.web.exercise.web;

import com.ycshang.web.exercise.entity.User;
import com.ycshang.web.exercise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @author ycshang
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        //判断用户是否勾选
        String remember = request.getParameter("remember");


        //2、调用service登录
        User user = userService.login(username, password);

        //    3、判断
        if (user != null) {
            //    跳转处理
            if ("on".equals(remember)) {
                System.out.println("记录Cookie");
                //    1、创建Cookie对象
                Cookie cUsername = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", password);
                //    2、设置存活时间
                cUsername.setMaxAge(60 * 60 * 24 * 7);
                cPassword.setMaxAge(60 * 60 * 24 * 7);
                //    3、发送
                response.addCookie(cUsername);
                response.addCookie(cPassword);
            }
            //将用户信息记在session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/index");

        } else {
            //    登录失败记录信息
            request.setAttribute("msg", "用户名或密码错误");
            //    转发
            request.getRequestDispatcher("/result.jsp").forward(request, response);

        }

    }
}
