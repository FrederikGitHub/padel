package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    @Autowired
    DataStore dataStore;


    @Override
    public void create(TimeSlot timeSlot) {
        dataStore.create(timeSlot);
    }

    @Override
    public void update(TimeSlot timeSlot) {
        dataStore.update(timeSlot);
    }

    @Override
    public void delete(TimeSlot timeSlot) {
        dataStore.delete(timeSlot);
    }

    @Override
    public List<TimeSlot> getTimeSlots() {
        return dataStore.getTimeSlots().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public List<TimeSlot> getDayTimeSlots(DayOfWeek dayOfWeek) {
        return dataStore.getTimeSlots().stream().filter(TimeSlot.Predicates.withDayOfWeek(dayOfWeek)).sorted().collect(Collectors.toList());
    }
}




