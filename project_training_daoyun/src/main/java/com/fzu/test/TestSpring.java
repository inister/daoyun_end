package com.fzu.test;

import com.fzu.domain.Role;
import com.fzu.domain.User;
import com.fzu.service.RoleService;
import com.fzu.service.UserService;
import com.fzu.service.impl.RoleServiceImpl;
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
}
