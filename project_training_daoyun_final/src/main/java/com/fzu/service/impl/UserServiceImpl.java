package com.fzu.service.impl;

import com.fzu.dao.UserDao;
import com.fzu.domain.User;
import com.fzu.service.UserService;
import com.fzu.utils.MD5Util;
import com.fzu.utils.NumberUtil;
import com.fzu.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    public User findById(int id) {
        User user = userDao.findById(id);
        return user;
    }

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        return user;
    }

    @Override
    public User findByNameAndPassword(User user) {
        return userDao.findByNameAndPassword(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserByToken(String token) {
        return userDao.getUserByToken(token);
    }

    @Override
    public User updateTokenAndLogin(String userName, String password) {
        User user = userDao.getUserByUserNameAndPassword(userName, password);
        if (user != null) {
            //登录后即执行修改token的操作
            String token = getNewToken(System.currentTimeMillis() + "", user.getUserId());
            if (userDao.updateUserToken(user.getUserId(), token) > 0) {
                //返回数据时带上token
                user.setToken(token);
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUserWithToken(User user) {
        userDao.updateUserWithToken(user);
    }

    @Override
    public void updateUserWithPassword(User user) {
        userDao.updateUserWithPassword(user);
    }

    //根据电话号码查询用户
    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    //更新主页
    @Override
    public void updateHomePage(User user) {
        userDao.updateHomePage(user);
    }

    @Override
    public int aSaveUser(User user) {
        return userDao.aSaveUser(user);
    }

    @Override
    public int aUpdateUser(User user) {
        return userDao.aUpdateUser(user);
    }

    @Override
    public int aRegister(String userName, String encodePassword, String role) {
        return userDao.aRegister(userName, encodePassword, role);
    }

    /**
     * 获取token值
     *
     * @param sessionId
     * @param userId
     * @return
     */
    private String getNewToken(String sessionId, int userId) {
        String src = sessionId + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);
    }

}
