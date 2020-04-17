package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.Course;
import cn.jpy.daoyun_end.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * 查询所有课程
     * @return
     */
    @GetMapping(value = "/courses")
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    // 新增课程
    @PostMapping(value = "/courses")
    public Course userAdd(@RequestParam("courseName") String courseName,
                        @RequestParam("createTime") Date createTime,
                        @RequestParam("creator") Integer creator
                        ) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCreateTime(createTime);
        course.setCreator(creator);
        return courseRepository.save(course);
    }

    // 通过id查询
    @GetMapping(value = "/courses/{id}")
    public Course courseFindOne(@PathVariable("id") Integer id) {
        return courseRepository.findById(id).get();
    }

    // 更新
    @PutMapping(value = "/courses/{id}")
    public Course courseUpdate(@PathVariable("id") Integer id,
                           @RequestParam("courseName") String courseName,
                           @RequestParam("createTime") Date createTime,
                           @RequestParam("creator") Integer creator) {
        Course course = new Course();
        course.setCourseId(id);
        course.setCourseName(courseName);
        course.setCreateTime(createTime);
        course.setCreator(creator);
        return courseRepository.save(course);

    }

    // 删除
    @DeleteMapping(value = "/courses/{id}")
    public void courseDelete(@PathVariable("id") Integer id) {
        courseRepository.deleteById(id);
    }
}
