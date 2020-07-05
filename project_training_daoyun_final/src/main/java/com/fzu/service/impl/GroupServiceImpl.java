package com.fzu.service.impl;

import com.fzu.dao.GroupDao;
import com.fzu.domain.Group;
import com.fzu.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupService")
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }

    @Override
    public Group findById(int groupId) {
        return groupDao.findById(groupId);
    }

    @Override
    public void update(Group group) {
        groupDao.update(group);
    }

    @Override
    public void delete(int groupId) {
        groupDao.delete(groupId);
    }

    @Override
    public int save(Group group) {
        return groupDao.save(group);
    }
}
