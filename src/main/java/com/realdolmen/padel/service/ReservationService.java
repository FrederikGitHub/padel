package com.realdolmen.padel.service;

import com.realdolmen.padel.model.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReservationService {

    public void generateReservations(Date fromDate, Date toDate, List<TimeSlot> timeSlotList, Group group);

    public List<Reservation> getMemberReservations(Member member, Date fromDate, Date toDate, List<ReservationType> reservationTypeList);

    public Map<Court,List<Reservation>> getDayReservations(Date day);

    void delete(Long id);

    void create(Reservation reservation);

    void update(Reservation reservation);
}
