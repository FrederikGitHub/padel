package com.realdolmen.padel.model;

import java.util.Objects;
import java.util.function.Predicate;

public class CourtTimeSlot {
    private long id;
    private TimeSlot timeSlot;
    private Court court;

    public CourtTimeSlot(long id, TimeSlot timeSlot, Court court) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.court = court;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourtTimeSlot that = (CourtTimeSlot) o;
        return id == that.id && timeSlot == that.timeSlot && Objects.equals(court, that.court);
    }

    @Override
    public String
    toString() {
        return "CourtTimeSlot{" +
                "id=" + id +
                ", timeSlot=" + timeSlot +
                ", court=" + court +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeSlot, court);
    }


    public static class Predicates {

        public static final Predicate<CourtTimeSlot> withId(final Long id) {
            return new Predicate<CourtTimeSlot>() {
                @Override
                public boolean test(CourtTimeSlot courtTimeSlot) {
                    return courtTimeSlot.getId() == id;
                }
            };
        }




    }
}
