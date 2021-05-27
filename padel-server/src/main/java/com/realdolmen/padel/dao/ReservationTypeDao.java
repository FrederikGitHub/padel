package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.GroupEntity;
import com.realdolmen.padel.entity.ReservationTypeEntity;

import java.util.List;

public interface ReservationTypeDao {

    void save(ReservationTypeEntity reservationEntity);

    void delete(ReservationTypeEntity reservationEntity);

    List<ReservationTypeEntity> getReservationTypeList();

    ReservationTypeEntity findReservationTypeById(Long id);
}
