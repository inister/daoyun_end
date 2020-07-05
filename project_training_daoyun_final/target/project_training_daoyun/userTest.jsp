<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/22
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>保存用户</h3>
<form action="user/save" method="post">
    <label>token：</label>
    <input type="text" name="token" placeholder="token" /><br/>
    <label>用户名：</label>
    <input type="text" name="userName" /><br/>
<%--    <label>密码：</label>--%>
<%--    <input type="text" name="password"  /><br/>--%>
    <label>真实姓名：</label>
    <input type="text" name="realName"  /><br/>
    <label>性别：</label>
    <input type="text" name="sex"  /><br/>
    <label>介绍：</label>
    <input type="text" name="introduction"  /><br/>
    <label>角色：</label>
    <input type="text" name="role"  /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>删除用户</h3>

<form action="user/delete" method="post">
    <label>token：</label>
    <input type="text" name="token" placeholder="token" /><br/>
    <label>id：</label>
    <input type="text" name="userId" placeholder="请输入id" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>更新用户</h3><br>
<form action="user/updateUser" method="post">
    <label>token：</label>
    <input type="text" name="token" placeholder="token" /><br/>
    <label>用户ID：</label>
    <input type="text" id="updateUserID" name="userId" placeholder="请输入ID" /><br/>
    <label>用户名：</label>
    <input type="text" id="userName" name="userName" placeholder="请输入用户名" /><br/>
    <label>真实姓名：</label>
    <input type="text" id="updateUsername" name="realName" placeholder="请输入真实姓名" /><br/>
    <label>介绍：</label>
    <input type="text" id="introduction" name="introduction" placeholder="请输入介绍" /><br/>
    <label>性别：</label>
    <input type="text" id="sex" name="sex" placeholder="请输入性别" /><br/>
    <label>角色：</label>
    <input type="text" id="role" name="role" placeholder="请输入角色" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>查询用户</h3>

<form action="user/findAll" method="post">
    <label>token：</label>
    <input type="password" name="token" placeholder="请输入token" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>更新主页</h3>

<%--real_name = #{realName}, emile = #{email}, phone = #{phone}, introduction = #{introduction} where user_id--%>
<form action="user/updateHomePage" method="post">
    <label>token：</label>
    <input type="text" name="token"/><br/>
    <label>真实姓名：</label>
    <input type="text" name="realName"/><br/>
    <label>email：</label>
    <input type="text" name="email"/><br/>
    <label>电话号码：</label>
    <input type="text" name="phone"/><br/>
    <label>介绍：</label>
    <input type="text" name="introduction"/><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>保存学生用户</h3>
<form action="user/asave" method="post">
    <label>用户名：</label>
    <input type="text" name="userName"/><br/>
    <label>真实姓名：</label>
    <input type="text" name="realName"/><br/>
    <label>学号：</label>
    <input type="text" name="studentId"/><br/>
    <label>出生年分：</label>
    <input type="text" name="birthday"/><br/>
    <label>性别：</label>
    <input type="text" name="sex"/><br/>
    <label>院系：</label>
    <input type="text" name="school"/><br/>
    <label>角色：</label>
    <input type="text" name="role"/><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>移动端用户注册</h3>
<form action="user/aregister" method="post">
    <label>userName：</label>
    <input type="text" name="userName"/><br/>
    <label>password：</label>
    <input type="text" name="password"/><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>移动端查询指定用户</h3>
<form action="user/afindUser" method="post">
    <label>userName：</label>
    <input type="text" name="userName"/><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

</body>
</html>
