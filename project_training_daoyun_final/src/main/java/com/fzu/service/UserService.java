package com.fzu.service;

import com.fzu.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户操作
     * @param user
     */
    int saveUser(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    User findByName(String userName);

    /**
     * 根据用户名和密码查询
     * @param user
     * @return
     */
    User findByNameAndPassword(User user);

    void updateUser(User user);

    /**
     * 根据token获取用户
     * @param token
     * @return
     */
    User getUserByToken(String token);

    /**
     * 登录功能
     * @param userName
     * @param password
     * @return
     */
    User updateTokenAndLogin(String userName, String password);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(int id);

    /**
     * 跟新用户token
     * @param user
     */
    void updateUserWithToken(User user);

    void updateUserWithPassword(User user);

    User findByPhone(String phone);

    User findByEmail(String email);

    void updateHomePage(User user);

    int aSaveUser(User user);

    int aUpdateUser(User user);

    //移动端注册用户
    int aRegister(String userName, String encodePassword, String role);
}
