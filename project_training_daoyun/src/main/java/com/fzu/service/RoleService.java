package com.fzu.service;

import com.fzu.domain.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);

    List<Role> findAll();
}
