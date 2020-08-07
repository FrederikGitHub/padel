package com.realdolmen.padel.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "POULE_TOUR", schema = "padel")
public class PouleTourEntity {

    @Id
    @Column(name = "POULE_TOUR_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "POULE_TOUR_FROM_DATE")
    private Timestamp fromDate;

    @Basic
    @Column(name = "POULE_TOUR_TO_DATE")
    private Timestamp toDate;


    @Basic
    @Column(name = "POULE_TOUR_PLAY_STATE_ID")
    private PlayStateEntity state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public PlayStateEntity getState() {
        return state;
    }

    public void setState(PlayStateEntity state) {
        this.state = state;
    }
}
