package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "court_timeslot", schema = "padel")
public class CourtTimeSlotEntity {
    @Id
    @Column(name = "COURT_TIMESLOT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "COURT_TIMESLOT_COURT_ID")
    private CourtEntity courtEntity;

    @ManyToOne
    @JoinColumn(name = "COURT_TIMESLOT_TIMESLOT_ID")
    private TimeSlotEntity timeSlotEntity;

    public CourtTimeSlotEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CourtEntity getCourtEntity() {
        return courtEntity;
    }

    public void setCourtEntity(CourtEntity courtEntity) {
        this.courtEntity = courtEntity;
    }

    public TimeSlotEntity getTimeSlotEntity() {
        return timeSlotEntity;
    }

    public void setTimeSlotEntity(TimeSlotEntity timeSlotEntity) {
        this.timeSlotEntity = timeSlotEntity;
    }
}
