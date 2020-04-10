package cn.jpy.daoyun_end.repository;

import cn.jpy.daoyun_end.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
