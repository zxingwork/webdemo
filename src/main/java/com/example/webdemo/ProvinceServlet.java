package com.example.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProvinceServlet", urlPatterns = "/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==>ProvinceServlet");
        req.setCharacterEncoding("UTF-8");
        String province = req.getParameter("province");
        System.out.println(province);
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
        printWriter.write("<root>");
        if ("广东".equals(province)){
            printWriter.write("<city>广州</city>");
            printWriter.write("<city>深圳</city>");
            printWriter.write("<city>中山</city>");
        }else if ("湖南".equals(province)){
            printWriter.write("<city>长沙</city>");
            printWriter.write("<city>株洲</city>");
            printWriter.write("<city>湘潭</city>");
            printWriter.write("<city>岳阳</city>");
        }
        printWriter.write("</root>");
        System.out.println("1111");
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
