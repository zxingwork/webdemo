package com.example.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String rs;
        if (!username.equals("")){
            if (username.equals("zhongfucheng")){
                rs = "you can't use the name;";
            }else {
                rs = "you can use the name;";
            }
        }else {
            rs = "please enter the name!";
        }
        out.write(rs);
    }
}
