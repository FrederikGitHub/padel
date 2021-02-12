package com.realdolmen.padel.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PlanningRequest {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Map<Week, java.util.List<CourtTimeSlot>> courtTimeSlotListByWeek;
    private List<Member> members;
    private Group group;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Map<Week, List<CourtTimeSlot>> getCourtTimeSlotListByWeek() {
        return courtTimeSlotListByWeek;
    }

    public void setCourtTimeSlotListByWeek(Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek) {
        this.courtTimeSlotListByWeek = courtTimeSlotListByWeek;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
