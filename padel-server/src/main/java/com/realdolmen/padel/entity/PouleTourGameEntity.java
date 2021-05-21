package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "poule_tour_game", schema = "padel")
public class PouleTourGameEntity {
    @Id
    @Column(name = "POULE_TOUR_GAME_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "POULE_TOUR_GAME_POULE_ID")
    private PouleEntity poule;

    @ManyToOne
    @JoinColumn(name = "POULE_TOUR_GAME_POULE_TOUR_ID")
    private PouleTourEntity pouleTour;

    @ManyToOne
    @JoinColumn(name = "POULE_TOUR_GAME_PLAY_STATE_ID")
    private PlayStateEntity state;

    @ManyToOne
    @JoinColumn(name = "POULE_TOUR_GAME_TIMESLOT_ID")
    private TimeSlotEntity timeslot;

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

    public PouleTourEntity getPouleTour() {
        return pouleTour;
    }

    public void setPouleTour(PouleTourEntity pouleTour) {
        this.pouleTour = pouleTour;
    }

    public PlayStateEntity getState() {
        return state;
    }

    public void setState(PlayStateEntity state) {
        this.state = state;
    }

    public TimeSlotEntity getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlotEntity timeslot) {
        this.timeslot = timeslot;
    }
}
