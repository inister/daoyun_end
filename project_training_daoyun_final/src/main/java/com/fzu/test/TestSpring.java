package com.fzu.test;

import com.fzu.domain.Role;
import com.fzu.domain.User;
import com.fzu.service.RoleService;
import com.fzu.service.UserService;
import com.fzu.service.impl.RoleServiceImpl;
import com.fzu.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class TestSpring {
    @Test
    public void testOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveRole() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = ac.getBean("roleService", RoleService.class);
        Role role = new Role();
        role.setRoleName("助教");
        role.setCreator(1);
        role.setCreateTime(new Date());
        roleService.saveRole(role);
    }

    @Test
    public void testUpdateRole() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = ac.getBean("roleService", RoleService.class);
        Role role = new Role();
//        update role set role_name = #{roleName} view_list = #{viewList}, view_detail = #{viewDetail}, add_employee = #{addEmployee}, add_teacher = #{addTeacher}," +
//            "delete_user = #{deleteUser}, reset_password = #{resetPassword}, add_course = #{addCourse}, edit_course = #{editCourse}," +
//            "delete_course = #{deleteCourse}, reload_system = #{reloadSystem}, close_system = #{closeSystem}, data_dictionary = #{dataDictionary}
        role.setRoleId(4);
        role.setRoleName("助教1");
        role.setViewPeopleList(1);
        role.setViewPeopleDetail(1);
        role.setAddEmployee(1);
        role.setAddTeacher(1);
        role.setDeleteUser(1);
        role.setResetPassword(1);
        role.setViewCourseList(1);
        role.setViewCourseDetail(1);
        role.setAddCourse(1);
        role.setEditCourse(1);
        role.setDeleteCourse(1);
        role.setReloadSystem(1);
        role.setCloseSystem(1);
        role.setDataDictionary(1);
        roleService.updateRole(role);
//        4	助教	1	2020-06-11 10:27:12	0	0	0	0	0	0	1	1	1	1	0	0	1	1
    }

    @Test
    public void testFindRoleById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = ac.getBean("roleService", RoleService.class);
        Role role = roleService.getRoleById(2);
        System.out.println(role);
    }

    @Test
    public void testupdateUserPassword() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setUserId(1);
        user.setPassword("123");
        userService.updateUserWithPassword(user);
    }

    @Test
    public void testGetUserByToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiLov5nph4zmmK_pop3lpJbnmoTkv6Hmga8sVVVJRGtleSIsInN1YiI6InpoYW5nc2FuIiwiaWF0IjoxNTkyNTcyNzAxLCJleHAiOjE1OTI2ODA3MDEsInV1aWRrZXkiOiLov5nph4zmmK_pop3lpJbnmoTkv6Hmga8sVVVJRGtleSJ9.sgioyzmKTTmBfmdJw1cOfBpECKDf48-1f8_9XDFvUgM";
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = userService.getUserByToken(token);
        System.out.println(user);
    }
}
