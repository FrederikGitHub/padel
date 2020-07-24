package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "PLAN", schema = "padel")
public class PlanEntity {
    @Id
    @Column(name = "PLAN_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "PLAN_DAY")
    private Integer day;

    @Basic
    @Column(name = "PLAN_MONTH")
    private Integer month;

    @Basic
    @Column(name = "PLAN_YEAR")
    private Integer year;

    @Basic
    @Column(name = "PLAN_WEEK")
    private Integer week;

    @ManyToOne
    @JoinColumn(name = "PLAN_TIMESLOT_ID")
    private TimeSlotEntity timeSlot;

    @ManyToOne
    @JoinColumn(name = "PLAN_MEMBER_ID")
    private MemberEntity member;

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

    public TimeSlotEntity getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlotEntity timeSlot) {
        this.timeSlot = timeSlot;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }
}
