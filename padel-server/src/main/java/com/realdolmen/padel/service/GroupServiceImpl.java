package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.exception.PadelMessageCode;
import com.realdolmen.padel.exception.PadelRuntimeException;
import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    DataStore dataStore;
    
    @Override
    public Group getGroup(String groupName) {
        Group group = null;
        Optional<Group> groupOptional = dataStore.getGroups().stream().filter(Group.Predicates.withGroupName(groupName)).findFirst();
        if (groupOptional.isPresent()) {
            group = groupOptional.get();
        }
        return group;
    }

    @Override
    public void create(Group group) {
        dataStore.create(group);
    }


    @Override
    public void update(Group group) {
        dataStore.update(group);
    }

    @Override
    public void delete(Long groupId) {
        if (membersPartOfGroup(groupId)) {
            throw new PadelRuntimeException(PadelMessageCode.MEMBER_PART_OF_GROUP);
        }
        Group group = new Group();
        group.setId(groupId);
        group.setActive("N");
        dataStore.update(group);
    }

    private boolean membersPartOfGroup(Long groupId){
        return dataStore.getPadelMembers().stream().filter(Member.Predicates.IS_ACTIVE.and(Member.Predicates.withGroupId(groupId))).findFirst().isPresent();
    }

    @Override
    public List<Group> getGroups() {
        return dataStore.getGroups().stream().filter(Group.Predicates.IS_ACTIVE).sorted().collect(Collectors.toList());
    }
}




