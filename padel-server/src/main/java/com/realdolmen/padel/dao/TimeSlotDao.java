package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.TimeSlotEntity;

import java.util.List;

public interface TimeSlotDao {
    void save(TimeSlotEntity timeSlotEntity);

    void delete(TimeSlotEntity timeSlotEntity);

    List<TimeSlotEntity> getTimeSlotList();
}
