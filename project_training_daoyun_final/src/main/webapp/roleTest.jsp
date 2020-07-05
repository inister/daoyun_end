<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/22
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色测试</title>
</head>
<body>

    <h3>查询所有课程</h3>
    <a href="class/findAll">点此查询所有课程</a>

    <h3>查询所有组</h3>
    <a href="group/findAll">点此查询所有组</a>

    <h3>查询字典</h3>
    <a href="dictionary/findAll">点此查询所有字典</a>

    <h3>查询所有角色</h3>
    <form action="role/findAll" method="post">
        <label>token：</label>
        <input type="text" name="token" placeholder="token"/><br/>
        <input type="submit" value="提交" />
        <input type="reset" value="重置" />
    </form>
<%--     role_name = #{roleName}, view_people_list = #{viewPeopleList}, view_people_detail = #{viewPeopleDetail}, add_employee = #{addEmployee}, " +
            "add_teacher = #{addTeacher}, delete_user = #{deleteUser}, reset_password = #{resetPassword},view_course_list = #{viewCourseList}, view_course_detail = #{viewCourseDetail}, add_course = #{addCourse}, " +
            "edit_course = #{editCourse}, delete_course = #{deleteCourse}, reload_system = #{reloadSystem}, close_system = #{closeSystem}, " +
            "data_dictionary = #{dataDictionary}--%>
    <h3>更新角色</h3>
    <form action="role/update" method="post">
        <label>token</label>
        <input type="text" name="token" /><br/>
        <label>角色id</label>
        <input type="text" name="roleId" /><br/>
        <label>角色名字</label>
        <input type="text" name="roleName" /><br/>
        <label>查看人员列表：</label>
        <input type="text" name="viewPeopleList"  /><br/>
        <label>查看人员详情：</label>
        <input type="text" name="viewPeopleDetail"  /><br/>
        <label>添加员工：</label>
        <input type="text" name="addEmployee"  /><br/>
        <label>添加老师：</label>
        <input type="text" name="addTeacher"  /><br/>
        <label>删除用户：</label>
        <input type="text" name="deleteUser"  /><br/>
        <label>重置密码：</label>
        <input type="text" name="resetPassword"  /><br/>
        <label>添加课程：</label>
        <input type="text" name="addCourse"  /><br/>
        <label>编辑课程：</label>
        <input type="text" name="editCourse"  /><br/>
        <label>删除课程：</label>
        <input type="text" name="deleteCourse"  /><br/>
        <label>重启系统：</label>
        <input type="text" name="reloadSystem"  /><br/>
        <label>关闭系统：</label>
        <input type="text" name="closeSystem"  /><br/>
        <label>数据字典：</label>
        <input type="text" name="dataDictionary"  /><br/>
        <label>查看课程列表：</label>
        <input type="text" name="viewCourseList"  /><br/>
        <label>查看课程详情：</label>
        <input type="text" name="viewCourseDetail"  /><br/>
        <input type="submit" value="提交" />
        <input type="reset" value="重置" />
    </form>

    <h3>保存角色</h3>
    <form action="role/save" method="post">
        <label>token</label>
        <input type="text" name="token" /><br/>
        <label>角色名字</label>
        <input type="text" name="roleName" /><br/>
        <label>查看人员列表：</label>
        <input type="text" name="viewPeopleList"  /><br/>
        <label>查看人员详情：</label>
        <input type="text" name="viewPeopleDetail"  /><br/>
        <label>添加员工：</label>
        <input type="text" name="addEmployee"  /><br/>
        <label>添加老师：</label>
        <input type="text" name="addTeacher"  /><br/>
        <label>删除用户：</label>
        <input type="text" name="deleteUser"  /><br/>
        <label>重置密码：</label>
        <input type="text" name="resetPassword"  /><br/>
        <label>添加课程：</label>
        <input type="text" name="addCourse"  /><br/>
        <label>编辑课程：</label>
        <input type="text" name="editCourse"  /><br/>
        <label>删除课程：</label>
        <input type="text" name="deleteCourse"  /><br/>
        <label>重启系统：</label>
        <input type="text" name="reloadSystem"  /><br/>
        <label>关闭系统：</label>
        <input type="text" name="closeSystem"  /><br/>
        <label>数据字典：</label>
        <input type="text" name="dataDictionary"  /><br/>
        <label>查看课程列表：</label>
        <input type="text" name="viewCourseList"  /><br/>
        <label>查看课程详情：</label>
        <input type="text" name="viewCourseDetail"  /><br/>
        <input type="submit" value="提交" />
        <input type="reset" value="重置" />
    </form>

    <h3>删除角色</h3>
    <form action="role/delete" method="post">
        <label>token：</label>
        <input type="text" name="token" placeholder="token"/><br/>
        <label>角色id：</label>
        <input type="text" name="roleId" placeholder="id"/><br/>
        <input type="submit" value="提交" />
        <input type="reset" value="重置" />
    </form>
</body>
</html>
