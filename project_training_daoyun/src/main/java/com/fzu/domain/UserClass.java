package com.fzu.domain;

import java.io.Serializable;

public class UserClass implements Serializable {
    private int userId;
    private int classId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
