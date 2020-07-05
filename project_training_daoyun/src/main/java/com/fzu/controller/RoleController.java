package com.fzu.controller;

import com.fzu.domain.Role;
import com.fzu.service.RoleService;
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
    /**
     * 查询所有角色
     */
    @RequestMapping("/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response, String token) throws IOException {
        List<Role> roles = roleService.findAll();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        for (Role role : roles) {
            response.getWriter().write(role.getRoleName() + "/" + role.getRoleAuthority());
            response.getWriter().write(";");
        }
    }
}
