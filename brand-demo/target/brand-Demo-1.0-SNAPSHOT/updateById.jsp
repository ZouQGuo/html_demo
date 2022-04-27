<%--
  Created by IntelliJ IDEA.
  User: 25511
  Date: 2022/4/19
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加数据</title>
</head>
<body>
<H3>添加品牌</H3>
<form action="/brand-demo/updateServlet" method="post">
    <%--隐藏域 提交id--%>
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<input name="description" value="${brand.description}"><br>
    状态：
    <c:if test="${brand.status==1}">
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1" checked="checked">启用<br>
    </c:if>

    <c:if test="${brand.status!=1}">
        <input type="radio" name="status" value="0" checked="checked">禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>

    <input type="submit" value="提交">
</form>
</body>
</html>
