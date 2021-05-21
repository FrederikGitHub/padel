package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.GroupEntity;
import com.realdolmen.padel.entity.MemberEntity;

import java.util.List;

public interface GroupDao {

    void save(GroupEntity groupEntity);

    void delete(GroupEntity groupEntity);

    List<GroupEntity> getGroupList();

    GroupEntity findGroupById(Long id);
}
