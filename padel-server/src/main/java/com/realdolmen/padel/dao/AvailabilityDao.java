package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.AvailabilityEntity;

import java.util.List;

public interface AvailabilityDao {

    void save(AvailabilityEntity availabilityEntity);

    void delete(AvailabilityEntity availabilityEntity);

    List<AvailabilityEntity> getAvailabilityList();
}
