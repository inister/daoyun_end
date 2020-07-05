package com.fzu.dao;

import com.fzu.domain.Group;
import org.apache.ibatis.annotations.*;
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

    @Select("select * from groups where group_id = #{groupId}")
    @ResultMap("groupMap")
    Group findById(int groupId);

    @Update("update groups set school = #{school}, college = #{college}, major = #{major} where group_id = #{groupId}")
    void update(Group group);

    @Delete("delete from groups where group_id = #{groupId}")
    void delete(int groupId);

    @Insert("insert into groups (school, college, major) values (#{school}, #{college}, #{major})")
    int save(Group group);
}
