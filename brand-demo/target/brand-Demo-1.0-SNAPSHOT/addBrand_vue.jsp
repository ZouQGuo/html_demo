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
<div id="app">
    <form action="" method="post">
        品牌名称：<input name="brandName" id="brandName" v-model="brand.brandName"><br>
        企业名称：<input name="companyName" id="companyName" v-model="brand.companyName"><br>
        排序：<input name="ordered" id="ordered" v-model="brand.ordered"><br>
        描述信息：<input name="description" id="description" v-model="brand.description"><br>
        状态：
        <input type="radio" name="status"  v-model="brand.status" value="0">禁用
        <input type="radio" name="status"  v-model="brand.status" value="1">启用<br>
        <input type="button" @click="submitForm" value="提交">
    </form>
</div>
<script src="js/vue.js"></script>
<script src="js/axios.js"></script>
<script>
    new Vue({
        el: "#app",
        data() {
            return {
                brand:{}
            }
        },
        methods:{
            submitForm(){
                //发送ajax请求
                var _this=this;
                //判断对象为空
                let stringify = JSON.stringify(_this.brand);
                if (stringify!="{}") {
                    axios({
                        method:"post",
                        url:"http://localhost:8080/brand-demo/addServlet_vue",
                        data:_this.brand
                    }).then(function (resp) {
                        //判断响应数据是否为success
                        if (resp.data=="success"){
                            //跳转
                            location.href="http://localhost:8080/brand-demo/brand_vue.jsp"
                        }
                    })
                }else {
                    alert("没有数据啊")
                }
            }
        }
    })
</script>
</body>
</html>
