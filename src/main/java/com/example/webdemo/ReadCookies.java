package com.example.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/ReadCookies")
public class ReadCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadCookies(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        cookies = req.getCookies();

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        String title = "Delete Cookie Example";
        String docType = "<!DOCTYPE html> \n";

        out.println(docType+
                "<html> \n"+
                "<head><title>"+title+"</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\"> \n");

        if (null != cookies){
            out.println("<h2>Cookie名称和值：</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                int n = (cookie.getName()).compareTo("name");
                System.out.println(n);
                if ((cookie.getName()).compareTo("name") == 0){
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    out.print("已删除的cookie："+
                            cookie.getName()+"<br/>");
                }
                out.print("名称："+cookie.getName()+"，  ");
                out.print("值："+ URLDecoder.decode(cookie.getValue(),"utf-8")+"<br/>");
            }
        }else {
            out.println("<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
