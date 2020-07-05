<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/12
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>组织测试</title>
</head>
<body>

<h3>组织查询</h3>
<form action="group/findAll" method="post">
    <label>token：</label>
    <input type="text" name="token"/><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>组织保存</h3>
<form action="group/save" method="post">
    <label>token：</label>
    <input type="text" name="token"/><br/>
    <label>学校：</label>
    <input type="text" name="school"  /><br/>
    <label>学院：</label>
    <input type="text" name="college"  /><br/>
    <label>专业：</label>
    <input type="text" name="major"  /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>组织更新</h3>
<form action="group/update" method="post">
    <label>token：</label>
    <input type="text" name="token"/><br/>
    <label>id：</label>
    <input type="text" name="groupId"  /><br/>
    <label>学校：</label>
    <input type="text" name="school"  /><br/>
    <label>学院：</label>
    <input type="text" name="college"  /><br/>
    <label>专业：</label>
    <input type="text" name="major"  /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>组织删除</h3>
<form action="group/delete" method="post">
    <label>id：</label>
    <input type="text" name="groupId"  /><br/>
    <label>token：</label>
    <input type="text" name="token"  /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
