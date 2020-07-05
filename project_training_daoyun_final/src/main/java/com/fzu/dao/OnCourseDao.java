package com.fzu.dao;

import com.fzu.domain.OnCourse;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OnCourseDao {

    @Select("select * from on_course where student_userName = #{userName}")
    @Results(id = "onCourseMap", value ={
            @Result(property = "OnCourseId", column = "on_course_id"),
            @Result(property = "OnCourseName", column = "on_course_name"),
            @Result(property = "teacherName", column = "teacher_name"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "userName", column = "student_userName"),
            })
    List<OnCourse> findByUserName(String userName);
}
