package com.fzu.domain;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    private int roleId;
    private String roleName;
    private int creator;
    private Date createTime;
    private int viewPeopleList;
    private int viewPeopleDetail;
    private int addEmployee;
    private int addTeacher;
    private int deleteUser;
    private int resetPassword;
    private int viewCourseList;
    private int viewCourseDetail;
    private int addCourse;
    private int editCourse;
    private int deleteCourse;
    private int reloadSystem;
    private int closeSystem;
    private int dataDictionary;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getViewPeopleList() {
        return viewPeopleList;
    }

    public void setViewPeopleList(int viewPeopleList) {
        this.viewPeopleList = viewPeopleList;
    }

    public int getViewPeopleDetail() {
        return viewPeopleDetail;
    }

    public void setViewPeopleDetail(int viewPeopleDetail) {
        this.viewPeopleDetail = viewPeopleDetail;
    }

    public int getAddEmployee() {
        return addEmployee;
    }

    public void setAddEmployee(int addEmployee) {
        this.addEmployee = addEmployee;
    }

    public int getAddTeacher() {
        return addTeacher;
    }

    public void setAddTeacher(int addTeacher) {
        this.addTeacher = addTeacher;
    }

    public int getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(int deleteUser) {
        this.deleteUser = deleteUser;
    }

    public int getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(int resetPassword) {
        this.resetPassword = resetPassword;
    }

    public int getViewCourseList() {
        return viewCourseList;
    }

    public void setViewCourseList(int viewCourseList) {
        this.viewCourseList = viewCourseList;
    }

    public int getViewCourseDetail() {
        return viewCourseDetail;
    }

    public void setViewCourseDetail(int viewCourseDetail) {
        this.viewCourseDetail = viewCourseDetail;
    }

    public int getAddCourse() {
        return addCourse;
    }

    public void setAddCourse(int addCourse) {
        this.addCourse = addCourse;
    }

    public int getEditCourse() {
        return editCourse;
    }

    public void setEditCourse(int editCourse) {
        this.editCourse = editCourse;
    }

    public int getDeleteCourse() {
        return deleteCourse;
    }

    public void setDeleteCourse(int deleteCourse) {
        this.deleteCourse = deleteCourse;
    }

    public int getReloadSystem() {
        return reloadSystem;
    }

    public void setReloadSystem(int reloadSystem) {
        this.reloadSystem = reloadSystem;
    }

    public int getCloseSystem() {
        return closeSystem;
    }

    public void setCloseSystem(int closeSystem) {
        this.closeSystem = closeSystem;
    }

    public int getDataDictionary() {
        return dataDictionary;
    }

    public void setDataDictionary(int dataDictionary) {
        this.dataDictionary = dataDictionary;
    }
}
