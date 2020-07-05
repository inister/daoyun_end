package com.fzu.controller;

import com.fzu.domain.OnCourse;
import com.fzu.service.OncourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/onCourse")
public class OnCourseController {
    @Autowired
    private OncourseService oncourseService;

    @RequestMapping("/findByName")
    @ResponseBody
    public List<OnCourse> findByUserName(String userName) {
        List<OnCourse> onCourseList = oncourseService.findByUserName(userName);
        return onCourseList;
    }
}
