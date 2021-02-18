package com.example.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Encoder;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;

@WebServlet("/GetCookies")
public class GetCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = req.getCookies();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String docType = "<!DOCTYPE html>\n";
        String title = "Cookie Show";

        Enumeration attr = req.getAttributeNames();
        Enumeration pram = req.getParameterNames();

        Cookie name = new Cookie("name", req.getParameter("name"));
        Cookie url = new Cookie("url",URLEncoder.encode(req.getParameter("url"),"UTF-8"));

        resp.addCookie(name);
        resp.addCookie(url);

        while (pram.hasMoreElements()){
            out.println("<b>"+pram.nextElement()+"</b>"+":"+req.getParameter((String) pram.nextElement()));
        }

        out.println(docType+
                "<html>"+
                "<head><title>"+title+"</title></head>"+
                "<body bgcolor=\"f0f0f0\">");

        if (null != cookies){
            out.println("<h2>Cookie List??</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                String p = cookie.getName();
                String value = URLDecoder.decode(cookie.getValue(),"UTF-8");
                out.println("<h3>"+"Name: "+p+"\t"+
                        "Value: "+value+"</h3>");
                out.println("<br/>");
            }
        }else {
            out.println("<h2>There are no Cookies in here</h2>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
