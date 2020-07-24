package com.realdolmen.padel.entity;

import javax.persistence.*;

public class CourtEntity {
    @Id
    @Column(name = "COURT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "COURT_NAME")
    private String name;

    public CourtEntity() {

    }

    public CourtEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
