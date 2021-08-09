package com.realdolmen.padel.model.builder;

import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.model.Reservation;
import com.realdolmen.padel.model.WeeklyReserve;

public class WeeklyReserveBuilder {
    private long id;
    private Integer weekNr;
    private Integer year;
    private Member member;
    private Group group;
    private Reservation reservation;


    public WeeklyReserveBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public WeeklyReserveBuilder setWeekNr(Integer weekNr) {
        this.weekNr = weekNr;
        return this;
    }

    public WeeklyReserveBuilder setYear(Integer year) {
        this.year = year;
        return this;
    }

    public WeeklyReserveBuilder setMember(Member member) {
        this.member = member;
        return this;
    }

    public WeeklyReserveBuilder setGroup(Group group) {
        this.group = group;
        return this;
    }

    public WeeklyReserveBuilder setReservation(Reservation reservation) {
        this.reservation = reservation;
        return this;
    }

    public WeeklyReserve build() {
        return new WeeklyReserve(id, weekNr, year, member, group,reservation);
    }
}
