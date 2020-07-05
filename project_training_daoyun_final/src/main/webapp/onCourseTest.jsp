<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/2
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>根据用户名查询班课</h3>
    <form action="onCourse/findByName" method="post">
        <label>用户名：</label>
        <input type="text" name="userName" placeholder="用户名"/><br/>
        <input type="submit" value="提交" />
        <input type="reset" value="重置" />
    </form>
</body>
</html>
