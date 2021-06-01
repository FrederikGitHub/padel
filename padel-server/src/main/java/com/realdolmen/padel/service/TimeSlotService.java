package com.realdolmen.padel.service;


import com.realdolmen.padel.model.TimeSlot;

import java.time.DayOfWeek;
import java.util.List;


public interface TimeSlotService {

    void create(TimeSlot timeSlot);

    void update(TimeSlot timeSlot);

    void delete(TimeSlot timeSlot);

    List<TimeSlot> getTimeSlots();

    List<TimeSlot> getDayTimeSlots(DayOfWeek dayOfWeek);


}
