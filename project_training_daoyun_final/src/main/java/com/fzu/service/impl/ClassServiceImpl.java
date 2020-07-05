package com.fzu.service.impl;

import com.fzu.dao.ClassDao;
import com.fzu.domain.Class;
import com.fzu.service.ClassService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classService")
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;

    @Override
    public List<Class> findAll() {
        return classDao.findAll();
    }

    @Override
    public Class findById(int classId) {
        return classDao.findById(classId);
    }

    @Override
    public void update(Class clazz) {
        classDao.update(clazz);
    }

    @Override
    public void delete(int classId) {
        classDao.delete(classId);
    }

    @Override
    public int save(Class clazz) {
        return classDao.save(clazz);
    }

//    ------------------------------------------Android-----------------------------------------------------------------

    @Override
    public List<Class> findAllTeacherCourse(String realName) {
        return classDao.findAllTeacherCourse(realName);
    }
}
