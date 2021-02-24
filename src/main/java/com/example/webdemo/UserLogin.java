package com.example.webdemo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.find(username, password);

        if (user==null){
            req.setAttribute("message", "用户名密码错误");
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        }

        req.getSession().setAttribute("user", user);
        req.setAttribute("message", "密码正确");

        Cookie cookie = new Cookie("autoLogin", user.getUsername()+"."+user.getPassword());

        cookie.setMaxAge(Integer.parseInt(req.getParameter("time"))*60);

        resp.addCookie(cookie);
        req.getRequestDispatcher("/message.jsp").forward(req, resp);
    }
}
