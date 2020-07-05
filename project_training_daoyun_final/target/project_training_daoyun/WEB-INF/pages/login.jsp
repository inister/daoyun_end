<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/21
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h3>登录</h3>
<form action="user/login" method="post">
    <label>账号：</label>
    <input type="text" id="loginUsername" name="userName" placeholder="请输入用户名" /><br/>
    <label>密码：</label>
    <input type="password" id="loginPassword" name="password" placeholder="请输入密码" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
