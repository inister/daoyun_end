package com.fzu.test;

import com.fzu.dao.ClassDao;
import com.fzu.dao.GroupDao;
import com.fzu.dao.RoleDao;
import com.fzu.dao.UserDao;
import com.fzu.domain.Class;
import com.fzu.domain.Group;
import com.fzu.domain.Role;
import com.fzu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMybatis {
    @Test
    public void testOne() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveRole() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        RoleDao roleDao = session.getMapper(RoleDao.class);
        Role role = new Role();
        role.setRoleName("助教");
        role.setCreator(1);
        role.setCreateTime(new Date());
        roleDao.saveRole(role);
        session.commit();
        is.close();
        session.close();
    }

    @Test
    public void testFindAllRole() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
        List<Role> roles = roleDao.findAll();
        System.out.println(roles);
    }

    @Test
    public void testFindAllClass() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        ClassDao classDao = sqlSession.getMapper(ClassDao.class);
        List<Class> classes = classDao.findAll();
        System.out.println(classes);
    }

    @Test
    public void testFindAllGroup() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        GroupDao groupDao = sqlSession.getMapper(GroupDao.class);
        List<Group> groups = groupDao.findAll();
        System.out.println(groups);
    }

    @Test
    public void testUpdateUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findByToken("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiLov5nph4zmmK_pop3lpJbnmoTkv6Hmga8sVVVJRGtleSIsInN1YiI6InpoYW5nc2FuIiwiaWF0IjoxNTkwMTU3NjQxLCJleHAiOjE1OTAxNTc3NjEsInV1aWRrZXkiOiLov5nph4zmmK_pop3lpJbnmoTkv6Hmga8sVVVJRGtleSJ9.KAEjISr3EhytJD9R16yFG9S1AkXkxiMRK9LlvbaUFaM");
        System.out.println(user);
    }
}
