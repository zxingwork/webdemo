<%--
  Created by IntelliJ IDEA.
  User: zhangxing
  Date: 2021/2/23
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UploadDemo</title>
</head>
<body>
<form action="/UploadServlet" enctype="multipart/form-data" method="post">
    上传用户：<input type="text" name="username"><br/>
    用户密码：<input type="password" name="password"><br/>
    上传文件1：<input type="file" name="file1"><br/>
    上传文件2：<input type="file" name="file2"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
