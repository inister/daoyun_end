package com.fzu.dao;

import com.fzu.domain.Class;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
            @Result(property = "requirement", column = "requirement")})
    List<Class> findAll();
}
