package com.fzu.service.impl;

import com.fzu.dao.DictionaryDao;
import com.fzu.domain.Dictionary;
import com.fzu.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryDao dictionaryDao;

    @Override
    public List<Dictionary> findAll() {
        return dictionaryDao.findAll();
    }
}
