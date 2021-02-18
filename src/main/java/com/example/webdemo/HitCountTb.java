package com.example.webdemo;

import java.sql.*;

public class HitCountTb {
    int pageId;
    String pageName;
    int hitcount;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://106.55.33.244:3306/admin";

    static final String USER = "root";
    static final String PASS = "Zxssjdy#111899";
    Connection conn = null;
    Statement stmt = null;

    public  ResultSet query(String sql) {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        return rs;
    }
    public void insert(String pageName, int hitcount) throws SQLException {
        String sql = "insert into hit_count(pagename,hitcount)values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,pageName);
        pstmt.setInt(2,hitcount);
        int result =pstmt.executeUpdate();
        System.out.println("插入状态："+result);
    }
}