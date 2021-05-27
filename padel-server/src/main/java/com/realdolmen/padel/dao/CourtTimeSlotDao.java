package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.CourtTimeSlotEntity;

import java.util.List;

public interface CourtTimeSlotDao {

    void save(CourtTimeSlotEntity courtTimeSlotEntity);

    void delete(CourtTimeSlotEntity courtTimeSlotEntity);

    List<CourtTimeSlotEntity> getCourtTimeSlotList();

    CourtTimeSlotEntity findCourtTimeSlotById(Long id);
}
