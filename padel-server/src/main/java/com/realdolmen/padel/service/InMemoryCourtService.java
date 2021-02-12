package com.realdolmen.padel.service;

import com.realdolmen.padel.data.InMemoryDataStore;
import com.realdolmen.padel.model.Court;
import com.realdolmen.padel.model.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("InMemoryCourtService")
public class InMemoryCourtService implements CourtService {


    @Override
    public Court getCourt(String courtName) {
        Court court = null;
        Optional<Court> courtOptional = InMemoryDataStore.getCourtList().stream().filter(Court.Predicates.withName(courtName)).findFirst();
        if (courtOptional.isPresent()){
            court = courtOptional.get();
        }
        return court;
    }

    @Override
    public void create(Court court) {
        InMemoryDataStore.getCourtList().add(court);
    }


    @Override
    public void update(Court padelCourt) {
        int index = 0;
        for (Court court:InMemoryDataStore.getCourtList()){
            if (court.equals(padelCourt)){
                break;
            }
            index++;
        }
        InMemoryDataStore.getCourtList().set(index,padelCourt);
    }

    @Override
    public void delete(Court court) {
        InMemoryDataStore.getPadelMembers().remove(court);
    }

    @Override
    public List<Court> getCourts() {
        return InMemoryDataStore.getCourtList().stream().sorted().collect(Collectors.toList());
    }
}




