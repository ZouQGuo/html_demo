<%--
  Created by IntelliJ IDEA.
  User: 25511
  Date: 2022/4/20
  Time: 13:07
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
<form action="/brand-demo/registerServlet" method="post">
    <table>
        <tr content="center">
            <th colspan="2">用户注册</th>
        </tr>
        <tr content="center">
            <td colspan="2" style="color: red" content="center">${reg_msg}</td>
        </tr>
        <tr>
            <lable for="username"><td>用户名</td></lable>
            <td><input name="username" type="text" id="username"></td>
        </tr>
        <tr>
            <td colspan="2" style="color: red"><span id="uname_err1" style="display: none" >用户名已存在</span></td><br>
        </tr>
        <tr>
            <td colspan="2" style="color: green"><span id="uname_msg" style="display: none" >用户名可用</span></td><br>
        </tr>
        <tr>
            <lable for="password"><td>密码</td></lable>
            <td><input name="password" type="password" id="password"></td>
        </tr>
        <tr>
            <td >验证码</td>
            <td >
                <input name="checkCode" type="text" id="checkCode" style="width: 20%">
                <img id="checkCodeImg" sizes="10%" src="/brand-demo/checkCodeServlet">
                <a href="#"  id="changImg" >看不清？</a>
            </td>
        </tr>
        <tr>
            <td><span id="pass_err" style="display: none">密码格式错误</span></td>
        </tr>
        <tr >
            <td>
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>
<script src="/js/axios.js"></script>
<script>
    document.getElementById("changImg").onclick=function () {
        document.getElementById("checkCodeImg").src="/brand-demo/checkCodeServlet?"+new Date().getMilliseconds();
    }
    document.getElementById("checkCodeImg").onclick=function () {
        document.getElementById("checkCodeImg").src="/brand-demo/checkCodeServlet?"+new Date().getMilliseconds();
    }

    //1 给用户名输入框绑定失去焦点事件
    document.getElementById("username").onblur=function () {
        //2 发送Ajax请求
        //获取用户名的值
        var username = this.value;
        // //2.1 创建Ajax核心对象
        // var xhttp;
        // if (window.XMLHttpRequest) {
        //     xhttp = new XMLHttpRequest();
        // } else {
        //     // code for IE6, IE5
        //     xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        // }
        // //2.2 发送请求
        // xhttp.open("GET", "http://localhost:8080/brand-demo/selectUserNameServlet?username="+username);
        // xhttp.send();
        // //2.3 获取响应
        // xhttp.onreadystatechange = function() {
        //     if (this.readyState == 4 && this.status == 200) {
        //       if (this.responseText != "true"){
        //           //用户名存在 显示提示信息
        //           document.getElementById("uname_err1").style.display='';
        //       }else {
        //           //用户名不存在  清楚提示
        //           document.getElementById("uname_err1").style.display='none';
        //       }
        //     }
        // };

        //1 get
        axios(
            {
                method:"get",
                url:"http://localhost:8080/brand-demo/selectUserNameServlet?username="+username,
            }
        ).then(function (resp) {
            if (resp.data!= true){
                //用户名存在 显示提示信息
                document.getElementById("uname_err1").style.display='';
                document.getElementById("uname_msg").style.display='none';
            }else {
                //用户名不存在 清楚不可用提示  提示可用
                document.getElementById("uname_err1").style.display='none';
                document.getElementById("uname_msg").style.display='';

            }

        });


        //2 post
        // axios({
        //     method: "post",
        //     url: "http://localhost:8080/brand-demo/selectUserNameServlet",
        //     data:"username="+username
        // }).then(function (resp) {
        //     alert(resp.data)
        // });
    }
</script>

<script>

</script>
</body>
</html>