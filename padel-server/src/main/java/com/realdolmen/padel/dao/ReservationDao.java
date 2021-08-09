package com.realdolmen.padel.dao;

import com.realdolmen.padel.entity.ReservationEntity;
import com.realdolmen.padel.model.CourtTimeSlot;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDao {
    void save(ReservationEntity reservationEntity);

    void delete(ReservationEntity reservationEntity);

    List<ReservationEntity> getReservationList();

    ReservationEntity findReservation(CourtTimeSlot courtTimeSlot, LocalDate localDate);

    ReservationEntity findReservationById(Long id);


}
