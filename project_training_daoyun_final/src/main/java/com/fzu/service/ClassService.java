package com.fzu.service;

import com.fzu.domain.Class;

import java.util.List;

public interface ClassService {
    List<Class> findAll();

    Class findById(int classId);

    void update(Class clazz);

    void delete(int classId);

    int save(Class clazz);

    List<Class> findAllTeacherCourse(String realName);
}
