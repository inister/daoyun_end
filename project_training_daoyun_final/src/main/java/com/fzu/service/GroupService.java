package com.fzu.service;

import com.fzu.domain.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    Group findById(int groupId);

    void update(Group group);

    void delete(int groupId);

    int save(Group group);
}
