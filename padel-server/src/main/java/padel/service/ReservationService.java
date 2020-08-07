package padel.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReservationService {

    public List<WeekPlanning> generateWeekPlanning(LocalDate fromDate, LocalDate toDate, List<TimeSlot> timeSlotList, Group group);

    public List<Reservation> getMemberReservations(Member member, Date fromDate, Date toDate, List<ReservationType> reservationTypeList);

    public Map<Court,List<Reservation>> getDayReservations(Date day);

    void delete(Long id);

    void create(Reservation reservation);

    void update(Reservation reservation);
}
