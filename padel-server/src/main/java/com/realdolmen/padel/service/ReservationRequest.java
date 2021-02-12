package com.realdolmen.padel.service;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.realdolmen.padel.model.CourtTimeSlot;
import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.util.UtcDateDeserializer;
import com.realdolmen.padel.util.UtcDateSerializer;
import java.time.LocalDate;

public class ReservationRequest {
    @JsonSerialize(using = UtcDateSerializer.class)
    @JsonDeserialize(using = UtcDateDeserializer.class)
    private LocalDate fromDate;

    @JsonSerialize(using = UtcDateSerializer.class)
    @JsonDeserialize(using = UtcDateDeserializer.class)
    private LocalDate toDate;

    private Group group;

    @JsonSerialize(using = UtcDateSerializer.class)
    @JsonDeserialize(using = UtcDateDeserializer.class)
    private LocalDate day;

    private CourtTimeSlot courtTimeSlot;

    private Member member;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public ReservationRequest setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public ReservationRequest setToDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public ReservationRequest setGroup(Group group) {
        this.group = group;
        return this;
    }

    public LocalDate getDay() {
        return day;
    }

    public ReservationRequest setDay(LocalDate day) {
        this.day = day;
        return this;
    }

    public CourtTimeSlot getCourtTimeSlot() {
        return courtTimeSlot;
    }

    public ReservationRequest setCourtTimeSlot(CourtTimeSlot courtTimeSlot) {
        this.courtTimeSlot = courtTimeSlot;
        return this;
    }

    public Member getMember() {
        return member;
    }

    public ReservationRequest setMember(Member member) {
        this.member = member;
        return this;
    }
}
