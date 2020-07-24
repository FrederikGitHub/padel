package com.realdolmen.padel.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "POULE_SCHEDULE", schema = "padel")
public class PouleScheduleEntity {

    @Id
    @Column(name = "POULE_SCHEDULE_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "POULE_SCHEDULE_POULE_ID")
    private PouleEntity poule;

    @Basic
    @Column(name = "POULE_SCHEDULE_FROM_DATE")
    private Timestamp fromDate;

    @Basic
    @Column(name = "POULE_SCHEDULE_TO_DATE")
    private Timestamp toDate;

    @Basic
    @Column(name = "POULE_SCHEDULE_STATE")
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PouleEntity getPoule() {
        return poule;
    }

    public void setPoule(PouleEntity poule) {
        this.poule = poule;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
