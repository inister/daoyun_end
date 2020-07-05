package com.fzu.dao;

import com.fzu.domain.Class;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface ClassDao {
    /*
    private int classId;
    private String className;
    private int creator;
    private Date createTime;
    private String teacherName;
    private int status;
    private String school;
    private String college;
    private String major;
    private String introduction;
    private String requirement;
     */
    @Select("select * from class")
    @Results(id = "classMap", value ={
            @Result(property = "classId", column = "class_id"),
            @Result(property = "className", column = "class_name"),
            @Result(property = "creator", column = "creator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "teacherName", column = "teacher_name"),
            @Result(property = "status", column = "status"),
            @Result(property = "school", column = "school"),
            @Result(property = "college", column = "college"),
            @Result(property = "major", column = "major"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "requirement", column = "requirement"),
            @Result(property = "grade", column = "grade")})
    List<Class> findAll();

    @Select("select * from class where class_id = #{classId}")
    @ResultMap("classMap")
    Class findById(int classId);

    @Update("update class set class_name = #{className}, teacher_name = #{teacherName}, school = #{school}, college = #{college}," +
    "major = #{major}, introduction = #{introduction}, requirement = #{requirement} where class_id = #{classId}")
    void update(Class clazz);

    @Delete("delete from class where class_id = #{classId}")
    void delete(int classId);

    @Insert("insert into class (class_name, teacher_name, school, college, major, introduction, requirement) values" +
            "(#{className}, #{teacherName}, #{school}, #{college}, #{major}, #{introduction}, #{requirement})")
    @ResultMap("classMap")
    int save(Class clazz);

    @Select("select * from class where teacher_name = #{name}")
    @ResultMap("classMap")
    List<Class> findAllTeacherCourse(String name);
}
