package com.example.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/PageHitCounter")
public class PageHitCounter extends HttpServlet {
    private int hitCount;

    @Override
    public void init() throws ServletException {
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        recordHit();
        resp.setContentType("text/html;charset=UTF-8");
        hitCount++;
        PrintWriter out = resp.getWriter();
        String title = "点击量";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType+
                "<html> \n"+
                "<head><title>"+title+"</title></head>"+
                "<body bgcolor=\"#f0f0f0\">"+
                "<h1 align='center'>"+title+"</h1>"+
                "<h2 align='center'>"+hitCount+"</h2>"+
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void recordHit() {
        HitCountTb countTb = new HitCountTb();
        try {
            countTb.insert("PageHitCounter",hitCount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
