package com.fzu.controller;

import com.fzu.domain.Class;
import com.fzu.domain.User;
import com.fzu.exception.AuthorityInadequateException;
import com.fzu.service.ClassService;
import com.fzu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response, String token) throws IOException {
        List<Class> classes = classService.findAll();
//        System.out.println(user);
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        for (Class aClass : classes) {
            response.getWriter().write(aClass.getClassId() + "/" +
                                        aClass.getClassName() + "/" +
                                        aClass.getTeacherName() + "/" +
                    aClass.getStatus() + "/" + aClass.getSchool() + "/" +
                    aClass.getCollege() + "/" + aClass.getMajor() + "/" +
                    aClass.getIntroduction() + "/" + aClass.getRequirement() + "/" + aClass.getClassId());
            response.getWriter().write(";");
        }
    }

    @RequestMapping("/update")
    public void update(HttpServletResponse response, Class clazz, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员") || roleName.equals("教师") || roleName.equals("助教")) {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            Class clazz1 = classService.findById(clazz.getClassId());
            if (clazz1 == null) {
                response.getWriter().write("modify_error");
            } else {
                classService.update(clazz);
                response.getWriter().write("modify_ok");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

    @RequestMapping("/delete")
    public void delete(HttpServletResponse response, Class clazz, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员") || roleName.equals("教师") || roleName.equals("助教")) {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            Class clazz1 = classService.findById(clazz.getClassId());
            if (clazz1 == null) {
                response.getWriter().write("delete_error");
            } else {
                classService.delete(clazz.getClassId());
                response.getWriter().write("delete_ok");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

    @RequestMapping("/save")
    public void save(HttpServletResponse response, Class clazz, String token) throws IOException, AuthorityInadequateException {
        User user = userService.getUserByToken(token);
        String roleName = user.getRole();
        if (roleName.equals("管理员") || roleName.equals("教师") || roleName.equals("助教")) {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            int success = classService.save(clazz);
            if (success == 1) {
                response.getWriter().write("save_ok");
            } else {
                response.getWriter().write("save_error");
            }
        } else {
            throw new AuthorityInadequateException("403");
        }
    }

//    ------------------------------------------------Android-----------------------------------------------------------

    @RequestMapping(value = "/course", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String findTeacherCourse(String userName, HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        User user = userService.findByName(userName);
        if (user == null) {
            return "not_this_people";
        }
//        System.out.println(user);
        String realName = user.getRealName();
//        System.out.println(realName);
        String role = user.getRole();
        String returnString = "";
//        System.out.println(role);
        if (role.equals("教师")){
            List<Class> classList = classService.findAllTeacherCourse(realName);
            for (Class clazz : classList) {
                returnString = returnString + "{ " + "className:" + clazz.getClassName() + "," + "teacherName:" + clazz.getTeacherName() + "," + "grade:" + clazz.getGrade() + "}";
            }

            return returnString;
        }else{
            return "403";
        }
    }

}
