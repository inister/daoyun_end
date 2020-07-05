package com.fzu.service.impl;

import com.fzu.dao.OnCourseDao;
import com.fzu.domain.OnCourse;
import com.fzu.service.OncourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("onCourseService")
public class OnCourseServiceImpl implements OncourseService {
    @Autowired
    private OnCourseDao onCourseDao;

    @Override
    public List<OnCourse> findByUserName(String userName) {
        return onCourseDao.findByUserName(userName);
    }
}
