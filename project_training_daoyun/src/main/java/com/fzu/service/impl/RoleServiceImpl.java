package com.fzu.service.impl;

import com.fzu.dao.RoleDao;
import com.fzu.domain.Role;
import com.fzu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
