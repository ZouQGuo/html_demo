<%--
  Created by IntelliJ IDEA.
  User: 25511
  Date: 2022/4/20
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="loginServlet" method="post">
    <table>
        <tr content="center">
            <th colspan="2">用户登录</th>
        </tr>
        <tr content="center">
            <td colspan="2" style="color: red" content="center">${login_msg}${reg_msg}</td>
        </tr>
        <tr content="center">
            <lable for="username"><td>用户名</td></lable>
            <td><input name="username" type="text" id="username" value="${cookie.username.value}"></td>
        </tr>
        <tr>
            <td><span id="uname_err" style="display: none">用户名填写错误</span></td>
        </tr>
        <tr>
            <lable for="password"><td>密码</td></lable>
            <td><input name="password" type="password" id="password" value="${cookie.password.value}"></td>
        </tr>
        <tr>
            <td><span id="pass_err" style="display: none">密码格式错误</span></td>
        </tr>
        <tr>
            <td colspan="2" content="center">
                记住密码：<input name="remember" id="remember" value="1" type="checkbox">
            </td>
        </tr>
        <tr content="center">
            <td>
                <input type="submit" value="登录">
            </td>
            <td>
                <a href="register_vue.jsp">注册</a>

            </td>
        </tr>
    </table>
</form>
<!--<script>-->
<!--    //1 获取表单输入框-->
<!--    var usernameInput = window.document.getElementById("user");-->
<!--    //2 绑定onblur 事件-->
<!--    usernameInput.onblur=function () {-->
<!--        //3 获取输入内容-->
<!--        var username = usernameInput.value()-->
<!--        alert(username)-->
<!--        //4 判断是否符合规则-->
<!--        if (username.length>10 || username.length<5){-->
<!--            //5 如果不符合规则提示错误信息-->
<!--            document.getElementById("uname_err").style.display='';-->
<!--        }-->
<!--    }-->
<!--</script>-->
</body>
</html>