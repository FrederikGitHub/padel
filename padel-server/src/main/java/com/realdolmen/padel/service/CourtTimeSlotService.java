package com.realdolmen.padel.service;


import com.realdolmen.padel.model.Court;
import com.realdolmen.padel.model.CourtTimeSlot;
import com.realdolmen.padel.model.TimeSlot;

import java.util.List;


public interface CourtTimeSlotService {

    List<CourtTimeSlot> getCourtTimeSlots();

    CourtTimeSlot findCourtTimeSlot(Court court, TimeSlot timeSlot);


}
