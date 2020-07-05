package com.fzu.controller;

import com.fzu.domain.Role;
import com.fzu.domain.User;
import com.fzu.exception.AuthorityInadequateException;
import com.fzu.service.RoleService;
import com.fzu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;
    /**
     * 查询所有角色
     */
    @RequestMapping("/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员")) {
            List<Role> roles = roleService.findAll();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            for (Role role : roles) {
                response.getWriter().write(role.getRoleName() + "/" + role.getViewPeopleList() + "/" +
                        role.getViewPeopleDetail() + "/" + role.getAddEmployee() + "/" + role.getAddTeacher() + "/" +
                        role.getDeleteUser() + "/" + role.getResetPassword() + "/" + role.getViewCourseList() + "/" +
                        role.getViewCourseDetail() + "/" + role.getAddCourse() + "/" + role.getEditCourse() + "/" +
                        role.getDeleteCourse() + "/" + role.getReloadSystem() + "/" + role.getCloseSystem() + "/" +
                        role.getDataDictionary() + "/" + role.getRoleId());
                response.getWriter().write(";");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

    /**
     * 角色修改
     */
    @RequestMapping("/update")
    public void update(HttpServletResponse response, Role role, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员")) {
            Role role1 = roleService.getRoleById(role.getRoleId());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            if (role1 == null) {
                response.getWriter().write("modify_error");
            } else {
                roleService.updateRole(role);
                response.getWriter().write("modify_ok");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

    /**
     * 删除角色
     */
    @RequestMapping("/delete")
    public void delete(HttpServletResponse response, Role role, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员")) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            Role role1 = roleService.getRoleById(role.getRoleId());
            if (role1 == null) {
                response.getWriter().write("delete_error");
            } else {
                roleService.delete(role.getRoleId());
                response.getWriter().write("delete_ok");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

    /**
     * 保存角色
     */
    @RequestMapping("save")
    public void save(HttpServletResponse response, Role role, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员")) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            int success = roleService.saveRole(role);
            if (success == 1) {
                response.getWriter().write("save_ok");
            } else {
                response.getWriter().write("save_error");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }
}
