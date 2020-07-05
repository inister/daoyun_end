package cn.jpy.daoyun_end.controller;

import cn.jpy.daoyun_end.entity.DictionaryData;
import cn.jpy.daoyun_end.repository.DictionaryDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionaryDataController {

    @Autowired
    private DictionaryDataRepository dictionaryDataRepository;

    @GetMapping("dictionarydata")
    public List<DictionaryData> findAllDicData() {
        return dictionaryDataRepository.findAll();
    }

}
