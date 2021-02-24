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
<form action="/UploadServlet" enctype="multipart/form-data" method="post" target="iframe1">
    上传用户：<input type="text" name="username"><br/>
    用户密码：<input type="password" name="password"><br/>
    上传文件1：<input type="file" id="file1"><br/>
    <input type="submit" id="submit" value="提交">
</form>
<iframe id="iframe1" name="iframe1" style="display: none"></iframe>
<script type="text/javascript">
    var file1 = document.getElementById("file1")
    file1.addEventListener("change", function () {
        var files = this.files;
        console.log(files);
        var filename = files[0].name;
        console.log(filename);
        file1.setAttribute("name", filename);
    })
    //当点击上传之后，会清除选择的文件
    var submit = document.getElementById("submit");
    submit.addEventListener("click", function () {
        file1.value ='';
        console.log(file1.files)
    })
</script>
</body>
</html>
