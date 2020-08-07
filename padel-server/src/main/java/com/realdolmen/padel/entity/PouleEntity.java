package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "POULE", schema = "padel")
public class PouleEntity {
    @Id
    @Column(name = "POULE_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
