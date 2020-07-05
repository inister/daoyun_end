package com.fzu.service;

import com.fzu.domain.Dictionary;

import java.util.List;

public interface DictionaryService {

    /**
     * 查询所有
     * @return
     */
    List<Dictionary> findAll();
}
