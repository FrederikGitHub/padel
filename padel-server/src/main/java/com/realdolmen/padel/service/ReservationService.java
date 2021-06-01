package com.realdolmen.padel.service;

import com.realdolmen.padel.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReservationService {

    void storeWeekPlanning(Set<WeekPlanning> weekPlannings,boolean validateTimeSlotOverBooking,boolean validateMemberOverBooking);

    boolean validateWeekPlanning(Set<WeekPlanning> weekPlannings,boolean validateTimeSlotOverBooking,boolean validateMemberOverBooking);

    Set<WeekPlanning> restGenerateWeekPlanning(LocalDate fromDate, LocalDate toDate, List<CourtTimeSlotWeek> courtTimeSlotWeekList, List<Member> members,Group group,boolean mixLevels);

    Set<WeekPlanning> generateWeekPlanning(LocalDate fromDate, LocalDate toDate, Map<Week,List<CourtTimeSlot>> courtTimeSlotListByWeek, List<Member> members,Group group,boolean mixLevels);
    //public Set<WeekPlanning> generateWeekPlanning(LocalDate fromDate, LocalDate toDate, List<CourtTimeSlot> courtTimeSlotList, Group group);

    Set<WeekPlanning> getGroupWeekPlanning(LocalDate fromDate, LocalDate toDate, Group group);

    Map<Member,Long> getTotalReservationsByMember(LocalDate fromDate, LocalDate toDate);

    Map<Member,Long> getTotalByeByMember(LocalDate fromDate, LocalDate toDate);

    List<Reservation> getDayReservations(LocalDate day);

    void delete(Long id);

    void deleteAllReservations();

    void create(Reservation reservation);

    void update(Reservation reservation);

    Reservation findReservationForPeriodAndCourtTimeSlot(LocalDate localdate, CourtTimeSlot courtTimeSlot);

    List<Reservation> findReservationsForPeriodAndMember(LocalDate startDate, LocalDate endDate, Member member);

    List<Reservation> findAllReservations();
}
