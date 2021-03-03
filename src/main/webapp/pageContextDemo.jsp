<%--
  Created by IntelliJ IDEA.
  User: zhangxing
  Date: 2021/2/27
  Time: 11:36 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContextDemo</title>
</head>
<body>
<div style="background-color: aliceblue;padding: 20px;border-radius: 10px;font-family: 'Microsoft Yahei'">
    <h1>PageContext调用内置方法：</h1>
    <br>
    <%
        out.println(pageContext.getSession());%><br><%
        out.println(pageContext.getRequest());%><br><%
        out.println(pageContext.getResponse());%><br><%

        out.println(pageContext.getException());%><br><%

        out.println(pageContext.getPage());%><br><%
        out.println(pageContext.getServletConfig());%><br><%
        out.println(pageContext.getServletContext());%><br><%
        out.println(pageContext.getOut());%><br><%
    %>
    <%
        pageContext.forward("/1.jsp");
    %>
</div>
</body>
</html>
