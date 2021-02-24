package com.example.mvcdemo.web;

import com.example.mvcdemo.dao.UserDao;
import com.example.mvcdemo.dao.daoimpl.UserImplXML;
import com.example.mvcdemo.model.User;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@WebServlet("/RegisterUIServlet")
public class RegisterUIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String ID = UUID.randomUUID().toString().replaceAll("-", "");

        UserImplXML userDao = new UserImplXML();
        User user = new User(ID, username, password, email, birthday);
        try {
            System.out.println("register");
            userDao.register(user);
            System.out.println(user.getBirthday());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
