package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.model.Court;
import com.realdolmen.padel.model.CourtTimeSlot;
import com.realdolmen.padel.model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourtTimeSlotServiceImpl implements CourtTimeSlotService {

    @Autowired
    DataStore dataStore;


    @Override
    public List<CourtTimeSlot> getCourtTimeSlots() {
        return dataStore.getCourtTimeSlots();
    }

    @Override
    public CourtTimeSlot findCourtTimeSlot(Court court, TimeSlot timeSlot) {
        List<CourtTimeSlot> courtTimeSlotList = dataStore.getCourtTimeSlots();
        return courtTimeSlotList.stream().filter(CourtTimeSlot.Predicates.withTimeSlotId(timeSlot.getId()).and(CourtTimeSlot.Predicates.withCourtId(court.getId()))).findFirst().get();
    }
}




