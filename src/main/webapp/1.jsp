<%--
  Created by IntelliJ IDEA.
  User: zhangxing
  Date: 2021/2/27
  Time: 11:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="error.jsp" %>
<html>
<head>
    <title>模拟空指针错误</title>
</head>
<body>
<%--模拟空指针的错误--%>
<%
    String s = null;
    s.length();
%>
</body>
</html>
