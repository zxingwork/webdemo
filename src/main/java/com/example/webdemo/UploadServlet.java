package com.example.webdemo;


import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "UploadServlet", urlPatterns = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> names = req.getAttributeNames();
        while (names.hasMoreElements()){
            System.out.println("attribute: "+names.nextElement());
        }

        ServletInputStream inputStream = req.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=inputStream.read(bytes))>0){
            System.out.println("in in");
            System.out.println(new String(bytes, 0, len));
        }
    }
}
