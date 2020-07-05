package com.fzu.controller;

import com.alibaba.fastjson.JSONObject;
import com.fzu.domain.User;
import com.fzu.service.UserService;
import com.fzu.utils.TokenUtil;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/token")
public class TokenController{
    @Autowired
    private UserService userService;

    @PostMapping(value = "/sign")
    @ResponseBody
    public Object sign(HttpServletRequest request, HttpServletResponse response, String username, String password) throws LoginException {
        System.out.println(username);
        System.out.println(password);
        User u = new User();
        u.setUserName(username);
        u.setPassword(password);
        User user = userService.findByNameAndPassword(u);
        System.out.println(user);
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        if (null==user) {
            throw new LoginException("no_this_people");
        }
        //生成一个token返回或者是放进响应头中
        String token = TokenUtil.getToken(user.getUserId(), user.getUserName());
        user.setToken(token);
        userService.updateUser(user);
        return token;
    }


}

