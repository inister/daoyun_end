package com.fzu.controller;

import com.fzu.domain.Group;
import com.fzu.domain.User;
import com.fzu.service.GroupService;
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

    @RequestMapping(value = "/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response, String token) throws IOException {
        List<Group> groups = groupService.findAll();
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        for (Group group : groups) {
            response.getWriter().write(group.getSchool() + "/" + group.getCollege() + "/" +
                    group.getMajor());
            response.getWriter().write(";");
        }

    }
}
