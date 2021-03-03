<%--
  Created by IntelliJ IDEA.
  User: zhangxing
  Date: 2021/2/28
  Time: 9:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>beandemo</title>
</head>
<body>
<jsp:useBean id="person" class="com.example.beandemo.Person" scope="page"/>
<jsp:setProperty name="person" property="username"/>
<jsp:setProperty name="person" property="age"/>
<%
    System.out.println(person.getUsername());
    System.out.println(person.getAge());
%>
</body>
</html>
