package padel.model;

import java.util.List;
import java.util.Objects;

public class Reservation {
    private long id;
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer week;
    private TimeSlot timeSlot;
    private List<Member> reservationMembers;

    public long getId() {
        return id;
    }

    public Reservation setId(long id) {
        this.id = id;
        return this;
    }

    public Integer getDay() {
        return day;
    }

    public Reservation setDay(Integer day) {
        this.day = day;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public Reservation setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Reservation setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getWeek() {
        return week;
    }

    public Reservation setWeek(Integer week) {
        this.week = week;
        return this;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Reservation setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
        return this;
    }

    public List<Member> getReservationMembers() {
        return reservationMembers;
    }

    public Reservation setReservationMembers(List<Member> reservationMembers) {
        this.reservationMembers = reservationMembers;
        return this;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", week=" + week +
                ", timeSlot=" + timeSlot +
                ", reservationMembers=" + reservationMembers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
