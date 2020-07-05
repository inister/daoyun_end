package com.fzu.controller;

import com.fzu.controller.annotation.TokenToUser;
import com.fzu.domain.User;
import com.fzu.exception.AuthorityInadequateException;
import com.fzu.exception.SysException;
import com.fzu.service.UserService;
import com.fzu.utils.BCryptPasswordUtil;
import com.fzu.utils.TokenUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
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
    public void findAll(HttpServletRequest request, HttpServletResponse response, String token) throws IOException, AuthorityInadequateException {
        User user1 = userService.getUserByToken(token);
//        System.out.println(user1);
        String role = user1.getRole();
//        System.out.println(role);
        if (role.equals("管理员")) {
            List<User> users = userService.findAll();
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            for (User user : users) {
                response.getWriter().write(user.getUserName() + "/" + user.getRealName() + "/"
                        + user.getRole() + "/" + user.getSex() + "/" + user.getIntroduction() + "/" + user.getUserId());
                response.getWriter().write(";");
            }
        }else {
            throw new AuthorityInadequateException("403");
        }
    }

    /**
     * 根据id查询用户
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/findById")
    public String findById(int userId, Model model, String token) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 保存用户
     * @param user
//     * @param model
     * @return
     */
    @RequestMapping("/save")
    public void saveUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException, AuthorityInadequateException {
//        user.setPassword(BCryptPasswordUtil.encodePassword(user.getPassword()));
        String token = user.getToken();
        User user2 = userService.getUserByToken(token);
        System.out.println(user2);
        String role = user2.getRole();
        System.out.println(role);
        if (role.equals("管理员")) {
//            String encodePassword = BCryptPasswordUtil.encodePassword(user.getPassword());
//            user.setPassword(encodePassword);
//            User user1 = user;
            int success = userService.saveUser(user);
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
//        response.sendRedirect(request.getContextPath() + "/user/findAll");
            if (success == 1) {
                response.getWriter().write("save_ok");
            } else {
                response.getWriter().write("save_error");
            }
        }else {
            throw new AuthorityInadequateException("403");
        }
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
    public void updateUser(User user, HttpServletResponse response) throws IOException, AuthorityInadequateException {
        String token = user.getToken();
        User user2 = userService.getUserByToken(token);
        String role = user2.getRole();
        if (role.equals("管理员")) {
            User user1 = userService.findById(user.getUserId());
            if (user1 == null) {
                response.getWriter().write("no_this_user");
            } else {
                userService.updateUser(user);
                response.getWriter().write("modify_ok");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, User user) throws IOException, LoginException {
        ModelAndView mv = new ModelAndView();
        String loginInfo = user.getUserName();
        //电话号码正则表达式
        String telRegex = "[1][3578]\\d{9}";
        String emailRegex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        boolean matchesPhone = loginInfo.matches(telRegex);
        boolean matchesEmail = loginInfo.matches(emailRegex);
        if (matchesPhone) {
            User user1 = userService.findByPhone(loginInfo);
            judgement(response, user, user1);
        } else if (matchesEmail) {
            User user1 = userService.findByEmail(loginInfo);
//            System.out.println(user1);
            judgement(response, user, user1);
        }else {
            User user1 = userService.findByName(loginInfo);
            judgement(response, user, user1);
        }

    }

    //该方法判断密码是否和数据符合
    public void judgement(HttpServletResponse response, User user, User user1) throws IOException {
        boolean b = BCryptPasswordUtil.decodePassword(user.getPassword(), user1.getPassword());
        if (b) {
//            User user1 =  userService.findByNameAndPassword(user);
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
//        if (null==user1) {
//            throw new LoginException("no_this_people");
//        }
            if (user1 != null) {
                //生成一个token返回或者是放进响应头中
                String token = TokenUtil.getToken(user1.getUserId(), user1.getUserName());
                user1.setToken(token);
//                System.out.println(token);
                userService.updateUserWithToken(user1);
                response.getWriter().write("ok");
                response.getWriter().write(";");
                response.getWriter().write(token);
                response.getWriter().write(";");
                response.getWriter().write(user1.getRealName() + "/" + user1.getEmail() + "/" + user1.getPhone() + "/" + user1.getIntroduction());
            }

        }else {
            response.getWriter().write("error");
        }
    }

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

    @RequestMapping("/delete")
    public void delete(User user, HttpServletResponse response) throws IOException, AuthorityInadequateException {
        String token = user.getToken();
        User user2 = userService.getUserByToken(token);
        String role = user2.getRole();
        if (role.equals("管理员")) {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            User user1 = userService.findById(user.getUserId());
            if (user1 == null) {
                response.getWriter().write("delete_error");
            } else {
                userService.deleteUser(user1.getUserId());
                response.getWriter().write("delete_ok");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }


    }

    @RequestMapping("/testException")
    public String testException(HttpServletResponse response) throws SysException {
        System.out.println("testException方法执行");
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        try {
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            return "error-sys";
        }
        return "success";
    }

    @RequestMapping("/updatePassword")
    public void updatePassword (HttpServletResponse response, User user) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
//        System.out.println(user.getUserId());
//        System.out.println(user.getPassword());
        User user1 = userService.findById(user.getUserId());
//        System.out.println(user1);
        if (user1 == null) {
            response.getWriter().write("not_this_people");
        } else {
            String encodePassword = BCryptPasswordUtil.encodePassword(user.getPassword());
            user1.setPassword(encodePassword);
//            System.out.println(user1);
            userService.updateUserWithPassword(user1);
            response.getWriter().write("OK");
        }
    }

    @RequestMapping("/updateHomePage")
    public void updateHomePage(HttpServletResponse response, User user) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        User user1 = userService.getUserByToken(user.getToken());
        if (user1 == null) {
            response.getWriter().write("not_this_people");
        }else {
            userService.updateHomePage(user);
            response.getWriter().write("modify_ok");
        }
    }

//    -----------------------------------------Android------------------------------------------------------------------

    @RequestMapping("/alogin")
    @ResponseBody
    public String alogin(HttpServletRequest request, HttpServletResponse response, User user) throws IOException, LoginException {
        ModelAndView mv = new ModelAndView();
        String loginInfo = user.getUserName();
        //电话号码正则表达式
        String telRegex = "[1][3578]\\d{9}";
        String emailRegex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        boolean matchesPhone = loginInfo.matches(telRegex);
        boolean matchesEmail = loginInfo.matches(emailRegex);
        if (matchesPhone) {
            User user1 = userService.findByPhone(loginInfo);
            return andoridJudgeLogin(response, user, user1);
        } else if (matchesEmail) {
            User user1 = userService.findByEmail(loginInfo);
            return andoridJudgeLogin(response, user, user1);
        }else {
            User user1 = userService.findByName(loginInfo);
            return andoridJudgeLogin(response, user, user1);
        }

    }

    public String andoridJudgeLogin(HttpServletResponse response, User user, User user1) {
        if (user1 == null) {
            return "username_not_exist";
        }
        boolean b = BCryptPasswordUtil.decodePassword(user.getPassword(), user1.getPassword());
        if (b) {
//            User user1 =  userService.findByNameAndPassword(user);
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
//        if (null==user1) {
//            throw new LoginException("no_this_people");
//        }
            if (user1 != null) {
                //生成一个token返回或者是放进响应头中
//                String token = TokenUtil.getToken(user1.getUserId(), user1.getUserName());
//                user1.setToken(token);
//                System.out.println(token);
//                userService.updateUserWithToken(user1);
                return "success";
            }

        }else {
            return "password_error";
        }
        return "password_error";
    }

    @RequestMapping("/asave")
    @ResponseBody
    public String aSaveUser(User user) {
        String userName = user.getUserName();
        User user1 = userService.findByName(userName);
        if (user1 == null) {
            int flag = userService.aSaveUser(user);
            if (flag == 1) {
                return "save_ok";
            }else {
                return "save_error";
            }
        }
        user.setUserId(user1.getUserId());
        int flag = userService.aUpdateUser(user);
        if (flag == 1) {
            return "update_ok";
        }else {
            return "update_error";
        }
    }

    @RequestMapping("/aregister")
    @ResponseBody
    public String aRegister(String userName, String password) {
        User user = userService.findByName(userName);
        if (user == null) {
            String encodePassword = BCryptPasswordUtil.encodePassword(password);
            String role = "学生";
//        System.out.println(userName);
//        System.out.println(password);
//        System.out.println(encodePassword);
            int flag = userService.aRegister(userName, encodePassword, role);
            if (flag == 1) {
                return "register_ok";
            }
        } else {
            return "error";
        }
        return "error";
    }

    @RequestMapping("/afindUser")
    @ResponseBody
    public User aFindUser(String userName, HttpServletResponse response) throws IOException {
        User user = userService.findByName(userName);
        if (user == null) {
            response.getWriter().write("error");
            return null;
        } else {
            return user;
        }
    }
}
