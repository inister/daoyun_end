package com.fzu.dao;

import com.fzu.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     * result的property属性代表类的属性名，column代表对应的数据库名字
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "email", column = "emile"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "role", column = "role"),
            @Result(property = "class1", column = "class"),
            @Result(property = "school", column = "school"),
            @Result(property = "major", column = "major"),
            @Result(property = "token", column = "user_token"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "birthday", column = "birthday")
    })
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @ResultMap注解的作用：引入上面的映射
     */
    @Select("select * from user where user_id = #{id}")
    @ResultMap("userMap")
    User findById(int id);

    /**
     * 保存用户操作
     * @param user
     */
//    user_name = #{userName}, real_name = #{realName}, sex = #{sex}, introduction = #{introduction}, role = #{role}
    @Insert("insert into user(user_name, real_name, sex, introduction, role) values " +
            "(#{userName},#{realName},#{sex},#{introduction},#{role})")
    @ResultMap("userMap")
    int saveUser(User user);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("select * from user where user_name = #{userName}")
    @ResultMap("userMap")
    User findByName(String userName);

    /**
     * 根据用户名和密码查询用户，主要用于登录功能
     * @param user
     * @return
     */
    @Select("select * from user where user_name = #{userName} and password = #{password}")
    @ResultMap("userMap")
    User findByNameAndPassword(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */

    @Update("update user set user_name = #{userName}, real_name = #{realName}, sex = #{sex}, introduction = #{introduction}, role = #{role} where user_id = #{userId}")
    @ResultMap("userMap")
    void updateUser(User user);

    /**
     * 根据token获取用户
     * @param token
     * @return
     */
    @Select("select * from user where user_token = #{token}")
    @ResultMap("userMap")
    User getUserByToken(String token);

    @Select("select user_id, user_name, user_token from user where user_name = #{userName} and password = #{password}")
    @Results(id = "r1", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "token", column = "user_token")
    })
    User getUserByUserNameAndPassword(@Param("userName") String userName, @Param("password")String password);

    @Update("update user set user_token = #{token} where user_id = #{userId}")
    @ResultMap("r1")
    int updateUserToken(@Param("userId")int userId, @Param("token")String token);

    @Select("select * from user where user_token = #{token}")
    @ResultMap("userMap")
    User findByToken(String token);

    @Delete("delete from user where user_id = #{id}")
    void deleteUser(int id);

    @Update("update user set user_token = #{token} where user_id = #{userId}")
    void updateUserWithToken(User user);

    @Update("update user set password = #{password} where user_id = #{userId}")
    void updateUserWithPassword(User user);

    @Select("select * from user where phone = #{phone}")
    @ResultMap("userMap")
    User findByPhone(String phone);

    @Select("select * from user where emile = #{email}")
    @ResultMap("userMap")
    User findByEmail(String email);


    @Update("update user set real_name = #{realName}, emile = #{email}, phone = #{phone}, introduction = #{introduction} where user_token = #{token}")
    void updateHomePage(User user);


    @Insert("insert into user(user_name, real_name, student_id, birthday, sex, school, role) values (#{userName}, #{realName}, #{studentId}, #{birthday}, #{sex}, #{school}, #{role})")
    int aSaveUser(User user);

    @Update("update user set user_name = #{userName}, real_name = #{realName}, student_id = #{studentId}, birthday = #{birthday}, sex = #{sex}, school = #{school}, role = #{role} where user_id = #{userId}")
    int aUpdateUser(User user);

    @Insert("insert into user (user_name, password, role) values (#{userName}, #{password}, #{role})")
    int aRegister(@Param("userName") String userName, @Param("password") String password, @Param("role") String role);
}
