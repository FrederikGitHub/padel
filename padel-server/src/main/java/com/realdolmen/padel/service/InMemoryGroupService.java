package com.realdolmen.padel.service;

import com.realdolmen.padel.data.InMemoryDataStore;
import com.realdolmen.padel.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("InMemoryCourtService")
public class InMemoryGroupService implements GroupService {


    @Override
    public Group getGroup(String groupName) {
        Group group = null;
        Optional<Group> groupOptional = InMemoryDataStore.getGroups().stream().filter(Group.Predicates.withGroupName(groupName)).findFirst();
        if (groupOptional.isPresent()) {
            group = groupOptional.get();
        }
        return group;
    }

    @Override
    public void create(Group group) {
        InMemoryDataStore.getGroups().add(group);
    }


    @Override
    public void update(Group padelGroup) {
        int index = 0;
        for (Group group : InMemoryDataStore.getGroups()) {
            if (group.equals(padelGroup)) {
                break;
            }
            index++;
        }
        InMemoryDataStore.getGroups().set(index, padelGroup);
    }

    @Override
    public void delete(Group group) {
        InMemoryDataStore.getGroups().remove(group);
    }

    @Override
    public List<Group> getGroups() {
        return InMemoryDataStore.getGroups().stream().sorted().collect(Collectors.toList());
    }
}




