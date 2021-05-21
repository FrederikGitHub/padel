package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "timeslot", schema = "padel")
public class TimeSlotEntity {

    @Id
    @Column(name = "TIMESLOT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "TIMESLOT_WEEKDAY_ID")
    private WeekDayEntity weekday;

    @Basic
    @Column(name = "TIMESLOT_FROM")
    private String from;

    @Basic
    @Column(name = "TIMESLOT_TO")
    private String to;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WeekDayEntity getWeekday() {
        return weekday;
    }

    public void setWeekday(WeekDayEntity weekday) {
        this.weekday = weekday;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
