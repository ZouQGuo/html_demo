<%--
  Created by IntelliJ IDEA.
  User: 25511
  Date: 2022/4/18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>${user.username},欢迎你</h2>
<input type="button" value="新增" id="add"><br>
<hr>
<div id="app">

<table border="1" cellspacing="0" width="800">
  <tr >
      <th>序号</th>
      <th>品牌名称</th>
      <th>企业名称</th>
      <th>排序</th>
      <th>品牌介绍</th>
      <th>状态</th>
      <th>操作</th>
  </tr>
<%--    <c:forEach items="${brands}" var="brand" varStatus="status">--%>
<%--        <tr align="center">--%>
<%--            <td>${status.count}</td>--%>
<%--            <td>${brand.brandName}</td>--%>
<%--            <td>${brand.companyName}</td>--%>
<%--            <td>${brand.ordered}</td>--%>
<%--            <td>${brand.description}</td>--%>
<%--            <c:if test="${brand.status == 1}">--%>
<%--                <td>启用</td>--%>
<%--            </c:if>--%>
<%--            <c:if test="${brand.status != 1}">--%>
<%--                <td>禁用</td>--%>
<%--            </c:if>--%>
<%--            <td><a href="/brand-demo/selectBrandByIdServlet?id=${brand.id}">修改</a> <a href="/brand-demo/deleteByIdServlet?id=${brand.id}">删除</a> </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

    <%-- 使用 v-for 遍历tr--%>
    <tr v-for="(brand,i) in brands" align="center">
        <td>{{i+1}}</td>
        <td>{{brand.brandName}}</td>
        <td>{{brand.companyName}}</td>
        <td>{{brand.order}}</td>
        <td>{{brand.description}}</td>
        <td>{{brand.statusStr}}</td>
        <td><a href="#">修改</a> <a href="#">删除</a> </td>
    </tr>
</table>
</div>
<script>
    //添加单击事件
    let onclick = document.getElementById("add").onclick=function () {
        location.href="/brand-demo/addBrand_vue.jsp"
    }
</script>

<script src="js/axios.js"></script>
<script src="js/vue.js"></script>
<script>
    new Vue({
        el:"#app",
        data(){
            return{
                brands:[]
            }
        },
        mounted(){
            var _this = this
            //页面加载完成后，发送异步请求 查询数据
            axios({
                method:"get",
                url:"http://localhost:8080/brand-demo/selectAllServlet_vue"
            }).then(function (resp) {
                _this.brands = resp.data;
            })
        }
    })

</script>
</body>
</html>
