package com.fzu.domain;

import java.io.Serializable;

public class Dictionary implements Serializable {
    private int dicId;
    private String dicName;

    public int getDicId() {
        return dicId;
    }

    public void setDicId(int dicId) {
        this.dicId = dicId;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }
}
