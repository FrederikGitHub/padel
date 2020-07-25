package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "PLAY_STATE", schema = "padel")
public class PlayStateEntity {

    @Id
    @Column(name = "PLAY_STATE_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "PLAY_STATE_STATE")
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
