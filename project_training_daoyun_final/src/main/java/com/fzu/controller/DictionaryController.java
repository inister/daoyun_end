package com.fzu.controller;

import com.fzu.domain.Dictionary;
import com.fzu.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/findAll")
    public void findAll(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<Dictionary> dictionaries = dictionaryService.findAll();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        for (Dictionary dictionary : dictionaries) {
            response.getWriter().write(dictionary.getDicEnglishName() + "/" +
                    dictionary.getDicChineseName() + "/" + dictionary.getDicStyle() + "/" +
                    dictionary.getDicStatus());
            response.getWriter().write(";");
        }
    }
}
