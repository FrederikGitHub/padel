package com.realdolmen.padel.model;

import java.time.LocalDate;

public class WeekTimeSlot {
    private LocalDate day;
    private CourtTimeSlot timeslot;
    private Week week;

    public LocalDate getDay() {
        return day;
    }

    public WeekTimeSlot setDay(LocalDate day) {
        this.day = day;
        return this;
    }

    public CourtTimeSlot getTimeslot() {
        return timeslot;
    }

    public WeekTimeSlot setTimeslot(CourtTimeSlot timeslot) {
        this.timeslot = timeslot;
        return this;
    }


    public Week getWeek() {
        return week;
    }

    public WeekTimeSlot setWeek(Week week) {
        this.week = week;
        return this;
    }

    @Override
    public String toString() {
        return "WeekTimeSlot{" +
                "day=" + day +
                ", timeslot=" + timeslot +
                ", weekNr=" + week +
                '}';
    }
}
