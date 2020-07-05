package com.fzu.domain;

import java.io.Serializable;

public class Dictionary implements Serializable {
    private int dicId;
    private String dicEnglishName;
    private String dicChineseName;
    private String dicStyle;
    private int dicStatus;

    public int getDicId() {
        return dicId;
    }

    public void setDicId(int dicId) {
        this.dicId = dicId;
    }

    public String getDicEnglishName() {
        return dicEnglishName;
    }

    public void setDicEnglishName(String dicEnglishName) {
        this.dicEnglishName = dicEnglishName;
    }

    public String getDicChineseName() {
        return dicChineseName;
    }

    public void setDicChineseName(String dicChineseName) {
        this.dicChineseName = dicChineseName;
    }

    public String getDicStyle() {
        return dicStyle;
    }

    public void setDicStyle(String dicStyle) {
        this.dicStyle = dicStyle;
    }

    public int getDicStatus() {
        return dicStatus;
    }

    public void setDicStatus(int dicStatus) {
        this.dicStatus = dicStatus;
    }
}
