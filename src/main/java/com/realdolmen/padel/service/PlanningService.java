package com.realdolmen.padel.service;

import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.TimeSlot;

import java.util.Date;
import java.util.List;

public interface PlanningService {

    public void createPlanning(Date fromDate, Date toDate, List<TimeSlot> timeSlotList, Group group);


}
