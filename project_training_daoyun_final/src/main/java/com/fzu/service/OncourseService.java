package com.fzu.service;

import com.fzu.domain.OnCourse;

import java.util.List;

public interface OncourseService {
    List<OnCourse> findByUserName(String userName);
}
