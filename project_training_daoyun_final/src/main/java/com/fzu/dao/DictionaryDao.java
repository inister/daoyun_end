package com.fzu.dao;

import com.fzu.domain.Dictionary;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DictionaryDao {
    //    private int dicId;
    //    private String dicEnglishName;
    //    private String dicChineseName;
    //    private String dicStyle;
    //    private int dicStatus;
    @Select("select * from dictionary")
    @Results(id = "dicMap", value = {
            @Result(property = "dicId", column = "dic_id"),
            @Result(property = "dicEnglishName", column = "dic_english_name"),
            @Result(property = "dicChineseName", column = "dic_chinese_name"),
            @Result(property = "dicStyle", column = "dic_style"),
            @Result(property = "dicStatus", column = "dic_status")
    })
    List<Dictionary> findAll();
}
