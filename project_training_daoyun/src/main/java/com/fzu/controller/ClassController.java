package com.fzu.controller;

import com.fzu.domain.Class;
import com.fzu.domain.User;
import com.fzu.service.ClassService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response, String token) throws IOException {
        List<Class> classes = classService.findAll();
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        for (Class aClass : classes) {
            response.getWriter().write(aClass.getClassId() + "/" +
                                        aClass.getClassName() + "/" +
                                        aClass.getTeacherName() + "/" +
                    aClass.getStatus() + "/" + aClass.getSchool() + "/" +
                    aClass.getCollege() + "/" + aClass.getMajor() + "/" +
                    aClass.getIntroduction() + "/" + aClass.getRequirement());
            response.getWriter().write(";");
        }


    }
}
