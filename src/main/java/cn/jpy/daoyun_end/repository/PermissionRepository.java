package cn.jpy.daoyun_end.repository;

import cn.jpy.daoyun_end.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
