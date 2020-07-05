package com.fzu.controller;

import com.alibaba.fastjson.JSONObject;
import com.fzu.common.Constants;
import com.fzu.common.Result;
import com.fzu.common.ResultGenerator;
import com.fzu.controller.annotation.TokenToUser;
import com.fzu.domain.User;
import com.fzu.service.UserService;
import com.fzu.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @param
     * @return
     */
    @RequestMapping(value = "/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response, String token) throws IOException {
        List<User> users = userService.findAll();
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        for (User user : users) {
            response.getWriter().write(user.getUserName() + "/" + user.getRealName() + "/"
                    + user.getRole() + "/" + user.getSex() + "/" + user.getIntroduction());
            response.getWriter().write(";");

        }

    }

    /**
     * 根据id查询用户
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/findById")
    public String findById(int userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 保存用户
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public void saveUser(User user, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.saveUser(user);
        response.sendRedirect(request.getContextPath() + "/user/findAll");
    }

    @RequestMapping("/findByName")
    public String findByName(Model model, String name) throws IOException {
        User user = userService.findByName(name);
        model.addAttribute("usersFindByName", user);
        return "success";
    }

    @RequestMapping("/findByNameAndPassword")
    public ModelAndView findByNameAndPassword(User user, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        User user1 =  userService.findByNameAndPassword(user);
        if (user1 != null) {
            mv.addObject("username", user1.getUserName());
            mv.addObject("user", user1);
            mv.setViewName("success");
        } else {
            mv.addObject("error", "用户名或者密码错误");
            return new ModelAndView("redirect:/index.jsp");
        }
        return mv;
    }

    @RequestMapping("/updateUser")
    public void updateUser(String newPassword,User user, HttpServletResponse response) throws IOException {
        System.out.println(newPassword);
        System.out.println(user.getPassword());
        System.out.println(user.getToken());
        User user1 = userService.findByToken(user.getToken());
        if (user1 == null) {
            response.getWriter().write("no_this_user");
        }else {
            user1.setPassword(newPassword);
            userService.updateUser(user1);
            response.getWriter().write("modify_ok");
        }
    }

//    @RequestMapping("/login")
//    public void login(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
//        ModelAndView mv = new ModelAndView();
//        User user1 =  userService.findByNameAndPassword(user);
//        if (user1 != null) {
//            response.getWriter().write("ok");
//        } else {
//            response.getWriter().write("login_error");
//        }
//    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(User user, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        response.setContentType("application/json;charset=utf-8");
        Result result = ResultGenerator.genFailResult("登录失败");
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            result.setMessage("请填写登录信息！");
        }
        System.out.println(user.getUserName() + "   " + user.getPassword());
        User loginUser = userService.updateTokenAndLogin(user.getUserName(), user.getPassword());
        if (loginUser != null) {
            result = ResultGenerator.genSuccessResult(loginUser);
            mv.addObject("result", result);
            mv.setViewName("success");
        }else {
            mv.setViewName("failure");
        }

        return mv;
    }

    /**
     * 检测token是否有效
     */
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public void test1(@TokenToUser User user, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        //此接口含有@TokenToUser注解，即需要登陆验证的接口。
        //Result result = null;
        if (user == null) {
            //如果通过请求header中的token未查询到用户的话即token无效，登陆验证失败，返回未登录错误码。
            //result = ResultGenerator.genErrorResult(Constants.RESULT_CODE_NOT_LOGIN, "未登录！");
            response.getWriter().write("未登录");
        } else {
            //登陆验证通过。
            //result = ResultGenerator.genSuccessResult("登陆验证通过");
            response.getWriter().write("登录通过");
        }
    }

    @RequestMapping(value="/loginByUser",method=RequestMethod.POST)
    @ResponseBody
    public String loginByUser(@RequestBody String userName, @RequestBody String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        JSONObject jo = new JSONObject();
        JSONObject parseObject = jo.parseObject(userName);
        System.out.println(parseObject.get("username"));

        String token = "";
        User user1 = userService.findByNameAndPassword(user);
        System.out.println(user1);
        if (user1!= null) {
            token = user1.getToken();
        }

        JSONObject resultJo = new JSONObject();
        resultJo.put("token", token);
        return JSONObject.toJSONString(resultJo).toString();
    }
}
