package com.realdolmen.padel.model;

import java.time.LocalDate;

public class WeekTimeSlot {
    private LocalDate day;
    private CourtTimeSlot courtTimeslot;
    private Week week;

    public LocalDate getDay() {
        return day;
    }

    public WeekTimeSlot setDay(LocalDate day) {
        this.day = day;
        return this;
    }

    public CourtTimeSlot getCourtTimeslot() {
        return courtTimeslot;
    }

    public WeekTimeSlot setCourtTimeslot(CourtTimeSlot courtTimeslot) {
        this.courtTimeslot = courtTimeslot;
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
                ", timeslot=" + courtTimeslot +
                ", weekNr=" + week +
                '}';
    }
}
