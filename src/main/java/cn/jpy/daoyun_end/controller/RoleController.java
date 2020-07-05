package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.Role;
import cn.jpy.daoyun_end.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "/roles")
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    // 新增角色
    @PostMapping(value = "/roles")
    public Role roleAdd(@RequestParam("createTime") Date createTime,
                          @RequestParam("creator") Integer creator,
                          @RequestParam("roleName") String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setCreateTime(createTime);
        role.setCreator(creator);

        return roleRepository.save(role);
    }


    // 通过id查询角色
    @GetMapping(value = "/roles/{id}")
    public Role roleFindOne(@PathVariable("id") Integer id) {
        return roleRepository.findById(id).get();
    }

    // 更新角色
    @PutMapping(value = "/roles/{id}")
    public Role roleUpdate(@PathVariable("id") Integer id,
                             @RequestParam("createTime") Date createTime,
                             @RequestParam("creator") Integer creator,
                             @RequestParam("roleName") String roleName  ) {
        Role role = new Role();
        role.setRoleId(id);
        role.setCreateTime(createTime);
        role.setCreator(creator);
        role.setRoleName(roleName);
        return roleRepository.save(role);

    }

    // 删除角色
    @DeleteMapping(value = "/roles/{id}")
    public void roleDelete(@PathVariable("id") Integer id) {
        roleRepository.deleteById(id);
    }
}
