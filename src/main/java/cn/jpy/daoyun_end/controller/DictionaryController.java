package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.Dictionary;
import cn.jpy.daoyun_end.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionaryController {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @GetMapping("dictionary")
    public List<Dictionary> findAllDictionary() {
        return dictionaryRepository.findAll();
    }

}
