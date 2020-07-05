package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.User;
import cn.jpy.daoyun_end.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户列表
     * @return 用户列表
     */
    @GetMapping(value = "/users")
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    /**
     * 添加用户
     * @param age
     * @param course
     * @param emile
     * @param password
     * @param phone
     * @param role
     * @param sex
     * @param userName
     * @return
     */
    @PostMapping(value = "/users")
    public User userAdd(@RequestParam("age") Integer age,
                        @RequestParam("course") Integer course,
                        @RequestParam("emile") String emile,
                        @RequestParam("password") String password,
                        @RequestParam("phone") String phone,
                        @RequestParam("role") Integer role,
                        @RequestParam("sex") Integer sex,
                        @RequestParam("userName") String userName) {
        User user = new User();
        user.setAge(age);
        user.setCourse(course);
        user.setEmile(emile);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRole(role);
        user.setSex(sex);
        user.setUserName(userName);
        return userRepository.save(user);
    }

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @GetMapping(value = "/users/{id}")
    public User userFindOne(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

    /**
     * 通过id更新用户
     * @param id
     * @param age
     * @param course
     * @param emile
     * @param password
     * @param phone
     * @param role
     * @param sex
     * @param userName
     * @return
     */
    @PutMapping(value = "/users/{id}")
    public User userUpdate(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("course") Integer course,
                           @RequestParam("emile") String emile,
                           @RequestParam("password") String password,
                           @RequestParam("phone") String phone,
                           @RequestParam("role") Integer role,
                           @RequestParam("sex") Integer sex,
                           @RequestParam("userName") String userName) {
        User user = new User();
        user.setUserId(id);
        user.setAge(age);
        user.setCourse(course);
        user.setEmile(emile);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRole(role);
        user.setSex(sex);
        user.setUserName(userName);
        return userRepository.save(user);
    }

    /**
     * 通过id删除用户
     * @param id
     */
    @DeleteMapping(value = "/users/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }


}
