package com.fzu.service.impl;

import com.fzu.dao.ClassDao;
import com.fzu.domain.Class;
import com.fzu.service.ClassService;
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
}
