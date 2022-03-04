<%@ page import="jakarta.servlet.http.HttpSession" %>
<% %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<h1>登录页面
</h1>
<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("user", "username:hello");
%>
<h3><%=request.getAttribute("msg")%>
</h3>

</body>
</html>