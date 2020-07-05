package com.fzu.dao;

import com.fzu.domain.Role;
import com.fzu.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface RoleDao {

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from role")
    @Results(id = "roleMap2", value = {
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "creator", column = "creator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "viewPeopleList", column = "view_people_list"),
            @Result(property = "viewPeopleDetail", column = "view_people_detail"),
            @Result(property = "addEmployee", column = "add_employee"),
            @Result(property = "addTeacher", column = "add_teacher"),
            @Result(property = "deleteUser", column = "delete_user"),
            @Result(property = "resetPassword", column = "reset_password"),
            @Result(property = "viewCourseList", column = "view_course_list"),
            @Result(property = "viewCourseDetail", column = "view_course_detail"),
            @Result(property = "addCourse", column = "add_course"),
            @Result(property = "editCourse", column = "edit_course"),
            @Result(property = "deleteCourse", column = "delete_course"),
            @Result(property = "reloadSystem", column = "reload_system"),
            @Result(property = "closeSystem", column = "close_system"),
            @Result(property = "dataDictionary", column = "data_dictionary")
    })
    List<Role> findAll();

    @Select("select * from role where role_id = #{roleId}")
    @ResultMap("roleMap2")
    Role getRoleById(int roleId);


    @Update("update role set role_name = #{roleName}, view_people_list = #{viewPeopleList}, view_people_detail = #{viewPeopleDetail}, add_employee = #{addEmployee}, " +
            "add_teacher = #{addTeacher}, delete_user = #{deleteUser}, reset_password = #{resetPassword},view_course_list = #{viewCourseList}, view_course_detail = #{viewCourseDetail}, add_course = #{addCourse}, " +
            "edit_course = #{editCourse}, delete_course = #{deleteCourse}, reload_system = #{reloadSystem}, close_system = #{closeSystem}, " +
            "data_dictionary = #{dataDictionary} where role_id = #{roleId}")
//            "add_teacher = #{addTeacher}, delete_user = #{deleteUser}, reset_password = #{resetPassword}, add_course = #{addCourse}, " +
//            "edit_course = #{editCourse}, delete_course = #{deleteCourse}, reload_system = #{reloadSystem}, close_system = #{closeSystem}," +
//            "data_dictionary = #{dataDictionary} where role_id = #{roleId}")
    @ResultMap("roleMap2")
    void update(Role role);

    @Delete("delete from role where role_id = #{roleId}")
    void delete(int roleId);

    /**
     * 保存角色
     * @param role
     */
    @Insert("insert into role(role_name, view_people_list, view_people_detail, add_employee , add_teacher, delete_user, reset_password,view_course_list, view_course_detail, add_course, edit_course, delete_course, reload_system, close_system, data_dictionary) values " +
            "(#{roleName}, #{viewPeopleList}, #{viewPeopleDetail}, #{addEmployee}, #{addTeacher}, #{deleteUser}, #{resetPassword},#{viewCourseList}, #{viewCourseDetail}, #{addCourse}, #{editCourse}, #{deleteCourse}, #{reloadSystem}, #{closeSystem}, #{dataDictionary})")
    @ResultMap("roleMap2")
    int saveRole(Role role);
}
