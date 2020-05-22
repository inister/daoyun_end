<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/22
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        /*设置token为全局变量*/
        var token = '';
        function fun02() {
            var name = $("#name").val();
            var password = $("#password").val();
            $.ajax({
                url: "/project_training_daoyun_war/token/sign",
                type: "post",
                data: {
                    username: name,
                    password: password
                },
                success: function (data) {
                    token = data
                    alert(token)
                }
            })

        }

        function fun01() {
            $.ajax({
                url: "/ajax",
                type: "get",
                data: {},
                headers: {'tokenHeader': token},
                success: function (data) {
                    alert(data)
                }
            })
        }
    </script>
</head>
<body>
<form id="login">
    姓名:<input type="text" name="username" id="name"><br>
    密码:<input type="password" name="password" id="password"><br>
    <input type="button" value="登录" onclick="fun02()">
</form>
<br>
<input type="button" value="ajax请求" onclick="fun01()">
</body>
</html>

