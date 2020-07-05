package com.fzu.controller;

import com.fzu.domain.Group;
import com.fzu.domain.User;
import com.fzu.exception.AuthorityInadequateException;
import com.fzu.service.GroupService;
import com.fzu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response, String token) throws IOException {
        List<Group> groups = groupService.findAll();
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        for (Group group : groups) {
            response.getWriter().write(group.getSchool() + "/" + group.getCollege() + "/" +
                    group.getMajor() + "/" + group.getGroupId());
            response.getWriter().write(";");
        }
    }

    @RequestMapping("/update")
    public void update(HttpServletResponse response, Group group, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员") || roleName.equals("教师") || roleName.equals("助教")) {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            Group group1 = groupService.findById(group.getGroupId());
            if (group1 == null) {
                response.getWriter().write("modify_error");
            } else {
                groupService.update(group);
                response.getWriter().write("modify_ok");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

    @RequestMapping("/delete")
    public void delete(HttpServletResponse response, Group group, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员") || roleName.equals("教师") || roleName.equals("助教")) {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            Group group1 = groupService.findById(group.getGroupId());
            if (group1 == null) {
                response.getWriter().write("delete_error");
            } else {
                groupService.delete(group.getGroupId());
                response.getWriter().write("delete_ok");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

    @RequestMapping("/save")
    public void save(HttpServletResponse response, Group group, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员") || roleName.equals("教师") || roleName.equals("助教")) {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            int success = groupService.save(group);
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
