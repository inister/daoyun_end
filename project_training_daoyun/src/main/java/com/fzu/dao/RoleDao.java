package com.fzu.dao;

import com.fzu.domain.Role;
import com.fzu.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    /**
     * 保存角色
     * @param role
     */
    @Insert("insert into role(role_name, creator, create_time) values " +
            "(#{roleName}, #{creator}, #{createTime})")
    @Results(id = "roleMap", value = {
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "creator", column = "creator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "roleAuthority",column = "role_authority")
    })
    void saveRole(Role role);

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from role")
    @Results(id = "roleMap", value = {
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "creator", column = "creator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "roleAuthority",column = "role_authority")
    })
    List<Role> findAll();
}
