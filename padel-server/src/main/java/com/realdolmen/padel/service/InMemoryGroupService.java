package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class InMemoryGroupService implements GroupService {

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
    public void delete(Group group) {
        dataStore.delete(group);
    }

    @Override
    public List<Group> getGroups() {
        return dataStore.getGroups().stream().filter(Group.Predicates.IS_ACTIVE).sorted().collect(Collectors.toList());
    }
}




