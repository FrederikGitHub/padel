package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.model.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryAvailabilityService implements AvailabilityService{


    @Autowired
    DataStore dataStore;


    @Override
    public List<Availability> getAvailabilities() {
        return dataStore.getAvailabilities();
    }
}
