package com.realdolmen.padel.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "reservation", schema = "padel")
public class ReservationEntity {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "RESERVATION_DAY")
    private Integer day;

    @Basic
    @Column(name = "RESERVATION_MONTH")
    private Integer month;

    @Basic
    @Column(name = "RESERVATION_YEAR")
    private Integer year;

    @Basic
    @Column(name = "RESERVATION_WEEK")
    private Integer week;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "reservation_member", joinColumns = {
            @JoinColumn(name = "RESERVATION_MEMBER_RESERVATION_ID")},
            inverseJoinColumns = {@JoinColumn(name = "RESERVATION_MEMBER_MEMBER_ID")})
    private Set<MemberEntity> reservationMembers;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_RESERVATION_TYPE_ID")
    private ReservationTypeEntity reservationType;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_GROUP_ID")
    private GroupEntity groupEntity;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_COURT_TIMESLOT_ID")
    private CourtTimeSlotEntity courtTimeSlotEntity;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="reservation")
    private Set<WeeklyReserveEntity> reserveList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public CourtTimeSlotEntity getCourtTimeSlot() {
        return courtTimeSlotEntity;
    }

    public void setCourtTimeSlot(CourtTimeSlotEntity courtTimeSlot) {
        this.courtTimeSlotEntity = courtTimeSlot;
    }

    public Set<MemberEntity> getReservationMembers() {
        return reservationMembers;
    }

    public void setReservationMembers(Set<MemberEntity> reservationMembers) {
        this.reservationMembers = reservationMembers;
    }

    public ReservationTypeEntity getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationTypeEntity reservationType) {
        this.reservationType = reservationType;
    }

    public GroupEntity getGroupEntity() {
        return groupEntity;
    }

    public void setGroupEntity(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
    }

    public Set<WeeklyReserveEntity> getReserveList() {
        return reserveList;
    }

    public ReservationEntity setReserveList(Set<WeeklyReserveEntity> reserveList) {
        this.reserveList = reserveList;
        return this;
    }
}
