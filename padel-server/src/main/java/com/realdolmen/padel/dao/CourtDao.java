package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.CourtEntity;

import java.util.List;

public interface CourtDao {
    void save(CourtEntity courtEntity);

    void delete(CourtEntity courtEntity);

    List<CourtEntity> getCourtList();


}
