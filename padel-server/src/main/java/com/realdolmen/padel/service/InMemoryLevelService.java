package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryLevelService implements LevelService{

    @Autowired
    DataStore dataStore;

    @Override
    public List<String> getLevels() {
        return dataStore.getVtvLevels();
    }
}
