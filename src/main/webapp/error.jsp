<%--
  Created by IntelliJ IDEA.
  User: zhangxing
  Date: 2021/2/27
  Time: 11:12 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>

<div class="ui-state-error-text" style="background-color: azure;padding: 10px">
    <%
        out.println("程序抛出了异常"+exception);
    %>
</div>
</body>
</html>
