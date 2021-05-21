package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.ReservationEntity;
import java.util.List;

public interface ReservationDao {
    void save(ReservationEntity reservationEntity);

    void delete(ReservationEntity reservationEntity);

    List<ReservationEntity> getReservationList();

    List<ReservationEntity> findReservationsByDay(Long id);

    ReservationEntity findReservationById(Long id);
}
