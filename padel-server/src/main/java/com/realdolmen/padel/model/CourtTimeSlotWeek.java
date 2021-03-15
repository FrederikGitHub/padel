package com.realdolmen.padel.model;

import java.util.List;

public class CourtTimeSlotWeek {
    private Week week;
    private List<CourtTimeSlot> courtTimeSlotList;

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public List<CourtTimeSlot> getCourtTimeSlotList() {
        return courtTimeSlotList;
    }

    public void setCourtTimeSlotList(List<CourtTimeSlot> courtTimeSlotList) {
        this.courtTimeSlotList = courtTimeSlotList;
    }
}
