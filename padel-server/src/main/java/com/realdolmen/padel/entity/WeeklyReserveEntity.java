package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "weekly_reserve", schema = "padel")
public class WeeklyReserveEntity {

    @Id
    @Column(name = "WEEKLY_RESERVE_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "WEEKLY_RESERVE_WEEK_NR")
    private Integer weekNr;

    @Basic
    @Column(name = "WEEKLY_RESERVE_YEAR")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "WEEKLY_RESERVE_MEMBER_ID")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "WEEKLY_RESERVE_GROUP_ID")
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "WEEKLY_RESERVE_RESERVATION_ID")
    private ReservationEntity reservation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getWeekNr() {
        return weekNr;
    }

    public void setWeekNr(Integer weekNr) {
        this.weekNr = weekNr;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

    public WeeklyReserveEntity setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
        return this;
    }
}
