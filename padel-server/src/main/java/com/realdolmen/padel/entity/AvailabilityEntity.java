package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "availability", schema = "padel")
public class AvailabilityEntity {
    @Id
    @Column(name = "AVAILABILITY_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "AVAILABILITY_LABEL")
    private String label;

    @Basic
    @Column(name = "AVAILABILITY_WEEK_NUMBERS")
    private String weekNumbers;

    public AvailabilityEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String name) {
        this.label = name;
    }

    public String getWeekNumbers() {
        return weekNumbers;
    }

    public void setWeekNumbers(String weekNumbers) {
        this.weekNumbers = weekNumbers;
    }
}
