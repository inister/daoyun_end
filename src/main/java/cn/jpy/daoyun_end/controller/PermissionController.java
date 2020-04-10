package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.Permission;
import cn.jpy.daoyun_end.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> findAllPermission() {
        return permissionRepository.findAll();
    }

}
