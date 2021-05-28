package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.model.Court;
import com.realdolmen.padel.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CourtServiceImpl implements CourtService {

    @Autowired
    DataStore dataStore;
    

    @Override
    public Court getCourt(String courtName) {
        Court court = null;
        Optional<Court> courtOptional = dataStore.getCourtList().stream().filter(Court.Predicates.withName(courtName)).findFirst();
        if (courtOptional.isPresent()){
            court = courtOptional.get();
        }
        return court;
    }

    @Override
    public void create(Court court) {
        dataStore.create(court);
    }

    @Override
    public void update(Court court) {
        dataStore.update(court);
    }

    @Override
    public void delete(Court court) {
        dataStore.delete(court);
    }

    @Override
    public List<Court> getCourts() {
        return dataStore.getCourtList().stream().filter(Court.Predicates.IS_ACTIVE).sorted().collect(Collectors.toList());

    }
}




