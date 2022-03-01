<%@ page import="com.ycshang.web.exercise.entity.User" %>
<%@ page import="com.ycshang.web.exercise.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");
%>

<div style="width: 100%;height: 60px; background-color:#4db6ac;;display: flex;justify-content: space-between;align-items: center">
    <span style="color: #fafafa;font-size: 18px;font-weight: bold;margin-left: 6px">Shopping Mall</span>
    <div style="width: 12%;display: flex;justify-content: space-around;align-items: center">
        <span style="color: #fafafa;font-size: 12px;">欢迎你:<%=user.getUsername()%></span>
        <img style="width: 45px;height: 45px;border-radius: 50px" src="${user.getAvatar()}"/>
        <a href="${pageContext.request.contextPath}/login.html" style="color: #fafafa;font-size: 12px;">退出</a>
    </div>
</div>
<div class="container">

    <input type="button" value="新增" id="add" style="background-color: #167f92;margin-bottom: 3px">
    <hr>

    <table class="responstable">
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <%
            for (Brand brand : brands) {
        %>
        <tr>
            <td><%=brand.getId()%>
            </td>
            <td><%=brand.getBrandName()%>
            </td>
            <td><%=brand.getCompanyName()%>
            </td>
            <td><%=brand.getOrdered()%>
            </td>
            <td><%=brand.getDescription()%>
            </td>
            <td>
                <%
                    if (brand.getStatus() == 0) {
                %>
                禁用
                <%
                } else {
                %>
                启用
                <%
                    }
                %>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/selectById?id=<%=brand.getId()%>">修改</a>
                <a href="${pageContext.request.contextPath}/delete?id=<%=brand.getId()%>">删除</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>


<script>
    document.getElementById("add").onclick = function () {
        location.href = "/addBrand.jsp";
    }


</script>
<style>
    .responstable {
        width: 95%;
        overflow: hidden;
        background: #FFF;
        color: #024457;
        border-radius: 10px;
        border: 1px solid #167F92;
    }

    .responstable tr {
        border: 1px solid #D9E4E6;
    }

    .responstable tr:nth-child(odd) {
        background-color: #EAF3F3;
    }

    .responstable th {
        display: none;
        border: 1px solid #FFF;
        background-color: #167F92;
        color: #FFF;
        padding: 1em;
    }

    .responstable th:first-child {
        display: table-cell;
        text-align: center;
    }

    .responstable th:nth-child(2) {
        display: table-cell;
    }

    .responstable th:nth-child(2) span {
        display: none;
    }

    .responstable th:nth-child(2):after {
        content: attr(data-th);
    }

    @media (min-width: 480px) {
        .responstable th:nth-child(2) span {
            display: block;
        }

        .responstable th:nth-child(2):after {
            display: none;
        }
    }

    .responstable td {
        display: block;
        word-wrap: break-word;
        max-width: 7em;
    }

    .responstable td:first-child {
        display: table-cell;
        text-align: center;
        border-right: 1px solid #D9E4E6;
    }

    @media (min-width: 480px) {
        .responstable td {
            border: 1px solid #D9E4E6;
        }
    }

    .responstable th, .responstable td {
        text-align: left;
        margin: .5em 1em;
    }

    @media (min-width: 480px) {
        .responstable th, .responstable td {
            display: table-cell;
            padding: 1em;
        }
    }

    /*body {*/
    /*        padding: 0 2em;*/
    /*        font-family: Arial, sans-serif;*/
    /*        color: #024457;*/
    /*        background: #f2f2f2;*/
    /*    }*/

    h1 {
        font-family: Verdana;
        font-weight: normal;
        color: #024457;
    }

    h1 span {
        color: #167F92;
    }

</style>
</body>
</html>