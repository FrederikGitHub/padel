package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "WEEKDAY", schema = "padel")
public class WeekDayEntity {
    @Id
    @Column(name = "WEEKDAY_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "WEEKDAY_NAME")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
