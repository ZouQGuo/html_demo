<%--
  Created by IntelliJ IDEA.
  User: 25511
  Date: 2022/4/19
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加数据</title>
</head>
<body>
<H3>添加品牌</H3>
<form action="/brand-demo/BrandAdd" method="post">
    品牌名称：<input name="brandName"><br>
    企业名称：<input name="companyName"><br>
    排序：<input name="ordered"><br>
    描述信息：<input name="description"><br>
    状态：
    <input type="radio" name="status" value="0">禁用
    <input type="radio" name="status" value="1">启用<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
