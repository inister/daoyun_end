<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/14
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <a href="user/findAll">查询所有用户</a>--%>
<%--    <h3>查询1个</h3><br>--%>
<%--    <form action="user/findById" method="post">--%>
<%--        id：<input type="text" name="userId"><br>--%>
<%--        <input type="submit" name="提交">--%>
<%--    </form>--%>
<%--    <br>--%>
<%--&lt;%&ndash;     private int userId;--%>
<%--    private String userName;--%>
<%--    private String password;--%>
<%--    private int sex;    // 0代表女，1代表男--%>
<%--    private int age;--%>
<%--    private String email;--%>
<%--    private String phone;--%>
<%--    private int role;--%>
<%--    private int class1;&ndash;%&gt;--%>
<%--    <form action="user/save" method="post">--%>
<%--        用户名：<input type="text" name="userName"><br>--%>
<%--        密码：<input type="password" name="password"><br>--%>
<%--        性别：<input type="text" name="sex"><br>--%>
<%--        年龄：<input type="text" name="age"><br>--%>
<%--        邮箱：<input type="text" name="email"><br>--%>
<%--        电话：<input type="text" name="phone"><br>--%>
<%--        角色：<input type="text" name="role"><br>--%>
<%--        班级：<input type="text" name="class1"><br>--%>
<%--        <input type="submit" name="提交">--%>
<%--    </form><br>--%>
<%--    <h3>根据名字查询</h3><br>--%>
<%--    <form action="user/findByName" method="post">--%>
<%--        用户名：<input type="text" name="name"><br>--%>
<%--        <input type="submit" name="提交">--%>
<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="user/findByNameAndPassword" method="post">
    <label>账号：</label>
    <input type="text" id="txtUsername" name="userName" placeholder="请输入用户名" /><br/>
    <label>密码：</label>
    <input type="password" id="txtPassword" name="password" placeholder="请输入密码" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<br/>
<br/>
<h3>更新用户</h3><br>
<form action="user/updateUser" method="post">
    <label>用户ID：</label>
    <input type="text" id="updateUserID" name="userId" placeholder="请输入ID" /><br/>
    <label>账号：</label>
    <input type="text" id="updateUsername" name="userName" placeholder="请输入账号" /><br/>
    <label>密码：</label>
    <input type="password" id="updatePassword" name="password" placeholder="请输入密码" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>
<h3>返回字符串</h3>
<a href="user/testString">点击返回字符串</a>

<h3>登录</h3>

<form action="user/loginByUser" method="post">
    <label>账号：</label>
    <input type="text" id="loginUsername" name="userName" placeholder="请输入用户名" /><br/>
    <label>密码：</label>
    <input type="password" id="loginPassword" name="password" placeholder="请输入密码" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>查询用户</h3>
<a href="user/findAll">点此查询用户</a>

<%--<jsp:forward page="WEB-INF/pages/login.jsp"></jsp:forward>--%>
<h3>更新用户</h3>

<form action="user/updateUser" method="post">
    <label>token：</label>
    <input type="text" id="token" name="token" placeholder="请输入token" /><br/>
    <label>旧密码：</label>
    <input type="text" id="loginUsername1" name="password" placeholder="请输入旧密码" /><br/>
    <label>新密码：</label>
    <input type="password" id="loginPassword1" name="newPassword" placeholder="请输入新密码" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
