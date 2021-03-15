package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.model.CourtTimeSlot;
import com.realdolmen.padel.model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class InMemoryCourtTimeSlotService implements CourtTimeSlotService {

    @Autowired
    DataStore dataStore;


    @Override
    public List<CourtTimeSlot> getCourtTimeSlots() {
        return dataStore.getCourtTimeSlots();
    }
}




