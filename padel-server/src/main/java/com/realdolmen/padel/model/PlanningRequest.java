package com.realdolmen.padel.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.realdolmen.padel.util.UtcDateDeserializer;
import com.realdolmen.padel.util.UtcDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanningRequest {
    @JsonSerialize(using = UtcDateSerializer.class)
    @JsonDeserialize(using = UtcDateDeserializer.class)
    private LocalDate fromDate;
    @JsonSerialize(using = UtcDateSerializer.class)
    @JsonDeserialize(using = UtcDateDeserializer.class)
    private LocalDate toDate;
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

    private List<CourtTimeSlotWeek> courtTimeSlotWeekList = new ArrayList<CourtTimeSlotWeek>();

    /*@JsonAnyGetter
    public Map<String, List<Long>> getCourtTimeSlotListByWeek() {
        return courtTimeSlotListByWeek;
    }

    @JsonAnySetter
    public void set(String weekKey, List<Long> courtTimeSlotList) {
        courtTimeSlotListByWeek.put(weekKey, courtTimeSlotList);
    }*/

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

    public List<CourtTimeSlotWeek> getCourtTimeSlotWeekList() {
        return courtTimeSlotWeekList;
    }

    public void setCourtTimeSlotWeekList(List<CourtTimeSlotWeek> courtTimeSlotWeekList) {
        this.courtTimeSlotWeekList = courtTimeSlotWeekList;
    }
}
