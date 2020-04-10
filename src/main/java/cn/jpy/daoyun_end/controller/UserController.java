package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.User;
import cn.jpy.daoyun_end.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 查询所有用户
    @GetMapping("user")
    public List<User> findAllUser() {
        return userRepository.findAll();
    }


}
