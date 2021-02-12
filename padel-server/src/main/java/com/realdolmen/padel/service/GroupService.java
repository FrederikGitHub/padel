package com.realdolmen.padel.service;


import com.realdolmen.padel.model.Group;

import java.util.List;


public interface GroupService {

    Group getGroup(String groupName);

    void create(Group groupName);

    void update(Group groupName);

    void delete(Group id);

    List<Group> getGroups();








}
