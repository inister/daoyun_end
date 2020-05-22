package com.fzu.domain;

import java.io.Serializable;

public class DictionaryData implements Serializable {
    private int dataId;
    private int dicId;
    private String value;
    private String dicName;
    private boolean isModify;

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getDicId() {
        return dicId;
    }

    public void setDicId(int dicId) {
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

    public boolean isModify() {
        return isModify;
    }

    public void setModify(boolean modify) {
        isModify = modify;
    }
}
