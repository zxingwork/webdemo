<%--
  Created by IntelliJ IDEA.
  User: zhangxing
  Date: 2021/2/28
  Time: 9:31 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/beandemo/1.jsp" method="post">
    <table>
        <tr>
            <th>HEAD</th>
        </tr>

        <tr>
            <td style="float: right">username:</td>
            <td><input name="username" type="text" id="username"></td>
        </tr>
        <tr>
            <td style="float: right">age:</td>
            <td><input name="age" type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" id="age"></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
            <td><input type="reset" value="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
