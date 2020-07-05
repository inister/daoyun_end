package com.fzu.service;

import com.fzu.domain.Role;

import java.util.List;

public interface RoleService {
    int saveRole(Role role);

    List<Role> findAll();

    Role getRoleById(int roleId);

    void updateRole(Role role);

    void delete(int roleId);
}
