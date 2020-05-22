package com.fzu.dao;

import com.fzu.domain.Group;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDao {
    /*
    private int gorupId;
    private String school;
    private String college;
    private String major;
     */
    @Select("select * from groups")
    @Results(id = "groupMap", value = {
            @Result(property = "groupId", column = "group_id"),
            @Result(property = "school", column = "school"),
            @Result(property = "college", column = "college"),
            @Result(property = "major", column = "major"),
    })
    List<Group> findAll();
}
