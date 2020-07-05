package com.fzu.domain;

public class OnCourse {
    private int OnCourseId;
    private String OnCourseName;
    private String teacherName;
    private String grade;
    private String userName;

    public int getOnCourseId() {
        return OnCourseId;
    }

    public void setOnCourseId(int onCourseId) {
        OnCourseId = onCourseId;
    }

    public String getOnCourseName() {
        return OnCourseName;
    }

    public void setOnCourseName(String onCourseName) {
        OnCourseName = onCourseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
