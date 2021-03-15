package com.realdolmen.padel.model;

import java.util.ArrayList;
import java.util.List;

public class AutoReservationRequest {

    private Group group;
    private List<Member> members;
    private PlanningDate fromDate;
    private PlanningDate toDate;
    private List<CourtTimeSlotWeek> courtTimeSlotWeekList = new ArrayList<CourtTimeSlotWeek>();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public PlanningDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(PlanningDate fromDate) {
        this.fromDate = fromDate;
    }

    public PlanningDate getToDate() {
        return toDate;
    }

    public void setToDate(PlanningDate toDate) {
        this.toDate = toDate;
    }

    public List<CourtTimeSlotWeek> getCourtTimeSlotWeekList() {
        return courtTimeSlotWeekList;
    }

    public void setCourtTimeSlotWeekList(List<CourtTimeSlotWeek> courtTimeSlotWeekList) {
        this.courtTimeSlotWeekList = courtTimeSlotWeekList;
    }
}
