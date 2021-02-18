package com.example.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
    private static final long serialVersionUID = 1l;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://106.55.33.244:3306/admin";

    static final String USER = "root";
    static final String PASS = "Zxssjdy#111899";

    public DatabaseAccess() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType+
                "<html>\n"+
                "<head><title>"+title+"</title></head>"+
                "<body gbcolor=\"#f0f0f0\">"+
                "<h1 align=\"center\">"+title+"</h1>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "Select id, name, url from websites";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                out.println("ID:"+id);
                out.println("NAME:"+name);
                out.println("URL:"+"<a href=\""+url+"\">"+url+"</a>");
                out.println("<br />");
            }
            out.println("</body></html>");
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt!=null) stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn!=null) conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
