<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/12
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班课测试</title>
</head>
<body>
<h3>保存班课</h3>
<%--(#{className}, #{teacherName}, #{school}, #{college}, #{major}, #{introduction}, #{requirement}--%>
<form action="class/save" method="post">
    <label>token：</label>
    <input type="text" name="token" /><br/>
    <label>课程名：</label>
    <input type="text" name="className" /><br/>
    <label>教师名称</label>
    <input type="text" name="teacherName" /><br/>
    <label>学校：</label>
    <input type="text" name="school"  /><br/>
    <label>学院：</label>
    <input type="text" name="college"  /><br/>
    <label>专业：</label>
    <input type="text" name="major"  /><br/>
    <label>介绍：</label>
    <input type="text" name="introduction"  /><br/>
    <label>要求：</label>
    <input type="text" name="requirement"  /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>修改班课</h3>

<form action="class/update" method="post">
    <label>token：</label>
    <input type="text" name="token" /><br/>
    <label>classId：</label>
    <input type="text" name="classId" /><br/>
    <label>课程名：</label>
    <input type="text" name="className" /><br/>
    <label>教师名称</label>
    <input type="text" name="teacherName" /><br/>
    <label>学校：</label>
    <input type="text" name="school"  /><br/>
    <label>学院：</label>
    <input type="text" name="college"  /><br/>
    <label>专业：</label>
    <input type="text" name="major"  /><br/>
    <label>介绍：</label>
    <input type="text" name="introduction"  /><br/>
    <label>要求：</label>
    <input type="text" name="requirement"  /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>查询班课</h3>
<form action="class/findAll" method="post">
    <label>token：</label>
    <input type="text" name="token" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>删除班课</h3>
<form action="class/delete" method="post">
    <label>token：</label>
    <input type="text" name="token" /><br/>
    <label>classId：</label>
    <input type="text" name="classId" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>

<h3>返回班课信息</h3>
<form action="class/course" method="post">
    <label>用户名：</label>
    <input type="text" name="userName" /><br/>
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
