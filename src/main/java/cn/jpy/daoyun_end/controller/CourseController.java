package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.Course;
import cn.jpy.daoyun_end.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("course")
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

}
