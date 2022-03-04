<%@ page import="jakarta.servlet.http.HttpSession" %>
<% Object user= session.getAttribute("user"); %><%--
  Created by IntelliJ IDEA.
  User: ycshang
  Date: 2022/3/4
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index静态页面</title>
</head>
<body style="background-color: antiquewhite">
index静态页面
<p>${user}</p>

</body>
</html>
