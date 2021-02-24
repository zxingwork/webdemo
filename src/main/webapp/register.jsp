<%--
  Created by IntelliJ IDEA.
  User: zhangxing
  Date: 2021/2/25
  Time: 1:24 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form method="post" action="/RegisterUIServlet">
    <table>
        <tr>
            <td>
                用户名：
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码：</td><td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>生日：</td><td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td>邮箱：</td><td><input type="email" name="email"></td>
        </tr>
        <tr><td><input type="submit" value="注册"></td><td><input type="reset" value="重置"></td></tr>
    </table>
</form>
</body>
</html>
