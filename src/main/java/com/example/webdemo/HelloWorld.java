package com.example.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    private String massage;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>"+massage+"</h1>");
        destroy();
    }

    @Override
    public void destroy() {
        System.out.println("被销毁!!");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        massage = "Hello World";
        System.out.println("初始化");
    }
}
