<%--
  Created by IntelliJ IDEA.
  User: zhangxing
  Date: 2021/2/22
  Time: 10:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多级联动</title>
</head>
<body>
<%--前台页面--%>
<select name="province" id="provinceId">
    <option value="-1">请选择省份</option>
    <option>广东</option>
    <option>湖南</option>
</select>
<select id="cityId">
    <option>请选择城市</option>
</select>

<%--AJAX--%>

<script type="text/javascript">

    document.getElementById("provinceId").onchange=function (){
        var index = this.selectedIndex;
        var province = this.options[index].innerHTML;
        if ("请选择省份"!=province){
            var citySelect = document.getElementById("cityId");
            citySelect.options.length = 1;

            var ajax;
            if (window.XMLHttpRequest){
                ajax = new XMLHttpRequest();
            }else {
                ajax = new ActiveXObject();
            }
            ajax.overrideMimeType("text/xml")
            var method = "POST";
            var url = "${pageContext.request.contextPath}/ProvinceServlet?time="+new Date().getTime();
            ajax.open(method, url);
            ajax.setRequestHeader("content-type", "application/x-www-form-urlencoded");
            ajax.send("province="+province);

            ajax.onreadystatechange = function (){
                if (ajax.readyState==4){
                    if (ajax.status==200){
                        var XMLDocument = ajax.responseXML;
                        console.log(XMLDocument)
                        var cities = XMLDocument.getElementsByTagName("city");
                        for (var i = 0;i<cities.length;i++){
                            var value = cities[i].firstChild.nodeValue;
                            console.log(value);

                            var optionElement = document.createElement("option");
                            optionElement.innerHTML = value;
                            console.log(optionElement);

                            citySelect.appendChild(optionElement);
                        }
                    }
                }
            }
        }
    }
</script>
</body>
</html>
