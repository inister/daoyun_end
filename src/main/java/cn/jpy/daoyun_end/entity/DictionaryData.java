package cn.jpy.daoyun_end.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DictionaryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dataId;
    private Integer dicId;  // 外键
    private String value;
    private String dicName;
    private Boolean isModify;

    public DictionaryData() {
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getDicId() {
        return dicId;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public Boolean getModify() {
        return isModify;
    }

    public void setModify(Boolean modify) {
        isModify = modify;
    }
}
