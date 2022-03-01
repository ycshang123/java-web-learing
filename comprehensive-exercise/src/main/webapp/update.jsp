<%@ page import="com.ycshang.web.exercise.entity.Brand" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UPDATE</title>
    <link href="css/style.css" rel="stylesheet">
    <style>

        table td {
            border: none;
            padding: 10px;
        }
    </style>
</head>



<body style="display:flex;justify-content: center;margin-top: 200px">
<%
    Brand brand = (Brand) request.getAttribute("brand");
%>
<div style="width: 40%; height:500px;background-color: #eaf3f3;border-radius:10px;display: flex;flex-direction: column;justify-content: center;box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);">

    <form action="${pageContext.request.contextPath}/updateBrand" method="post">
        <%--隐藏域，提交id--%>
        <input type="hidden" name="id" value="<%=brand.getId()%>">
        <table>
            <tr>
                <td>
                    <label for="brandName">
                        品牌名称
                    </label>
                </td>
                <td><input type="text" name="brandName" value="<%=brand.getBrandName()%>" id="brandName"></td>
            </tr>

            <tr>
                <td>
                    <label for="companyName">
                        企业名称
                    </label>
                </td>
                <td><input type="text" name="companyName" value="<%=brand.getCompanyName()%>" id="companyName"></td>
            </tr>

            <tr>
                <td>
                    <label for="ordered">
                        排序
                    </label>
                </td>
                <td><input type="text" name="ordered" value="<%=brand.getOrdered()%>" id="ordered"></td>
            </tr>

            <tr>
                <td>
                    <label for="description">
                        描述信息
                    </label>
                </td>
                <td>
                        <textarea name="description" rows="10" cols="50" id="description">
                              <%=brand.getDescription()%>
                        </textarea>
                </td>
            </tr>

            <tr>
                <td> 状态</td>
                <td>
                    <%
                        if (brand.getStatus() == 1) {
                    %>
                    <input name="status" type="radio" id="ok" value="1" checked>
                    <label for="ok">
                        启用
                    </label>
                    <input name="status" type="radio" id="no" value="0">
                    <label for="no">
                        禁用
                    </label>
                    <%
                    } else {
                    %>
                    <input name="status" type="radio" id="ok" value="1">
                    <label for="ok">
                        启用
                    </label>
                    <input name="status" type="radio" id="no" value="0" checked>
                    <label for="no">
                        禁用
                    </label>
                    <%
                        }
                    %>
                </td>
            </tr>
        </table>

            <div style="padding-left: 290px;padding-bottom: 20px">
            <input type="submit" value="提交" style="background-color: #167f92">
        </div>
    </form>

</div>

</body>
</html>
