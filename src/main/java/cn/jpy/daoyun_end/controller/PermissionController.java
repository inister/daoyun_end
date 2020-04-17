package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.Permission;
import cn.jpy.daoyun_end.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    // 查询所有菜单
    @GetMapping(value = "/permissions")
    public List<Permission> findAllPermission() {
        return permissionRepository.findAll();
    }

    // 新增菜单
    @PostMapping(value = "/permissions")
    public Permission permissionAdd(@RequestParam("menuName") String menuName,
                        @RequestParam("isPage") Boolean isPage,
                        @RequestParam("icon") String icon,
                        @RequestParam("link") String link) {
        Permission permission = new Permission();
        permission.setMenuName(menuName);
        permission.setPage(isPage);
        permission.setIcon(icon);
        permission.setLink(link);

        return permissionRepository.save(permission);
    }

    // 通过id查询
    @GetMapping(value = "/permissions/{id}")
    public Permission permissionFindOne(@PathVariable("id") Integer id) {
        return permissionRepository.findById(id).get();
    }

    // 更新
    @PutMapping(value = "/permissions/{id}")
    public Permission permissionUpdate(@PathVariable("id") Integer id,
                                       @RequestParam("menuName") String menuName,
                                       @RequestParam("isPage") Boolean isPage,
                                       @RequestParam("icon") String icon,
                                       @RequestParam("link") String link   ) {
        Permission permission = new Permission();
        permission.setPermId(id);
        permission.setLink(link);
        permission.setIcon(icon);
        permission.setPage(isPage);
        permission.setMenuName(menuName);

        return permissionRepository.save(permission);

    }

    // 删除
    @DeleteMapping(value = "/permissions/{id}")
    public void permissionDelete(@PathVariable("id") Integer id) {
        permissionRepository.deleteById(id);
    }
}
