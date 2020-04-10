package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.Role;
import cn.jpy.daoyun_end.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

}
