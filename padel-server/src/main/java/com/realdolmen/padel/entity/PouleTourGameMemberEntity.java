package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "POULE_TOUR_GAME_MEMBER", schema = "padel")
public class PouleTourGameMemberEntity {
    @Id
    @Column(name = "POULE_TOUR_GAME_MEMBER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "POULE_TOUR_GAME_MEMBER_POULE_TOUR_GAME_ID")
    private PouleTourGameEntity pouleTourGame;

    @ManyToOne
    @JoinColumn(name = "POULE_TOUR_GAME_MEMBER_MEMBER_ID")
    private MemberEntity member;

    @Basic
    @Column(name = "POULE_TOUR_GAME_MEMBER_POINTS")
    private Integer points;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PouleTourGameEntity getPouleTourGame() {
        return pouleTourGame;
    }

    public void setPouleTourGame(PouleTourGameEntity pouleTourGame) {
        this.pouleTourGame = pouleTourGame;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
