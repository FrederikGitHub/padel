package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "POULE_SCHEDULE_RESULT", schema = "padel")
public class PouleScheduleResultEntity {
    @Id
    @Column(name = "POULE_SCHEDULE_RESULT_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "POULE_SCHEDULE_RESULT_POULE_SCHEDULE_ID")
    private PouleScheduleEntity pouleSchedule;

    @ManyToOne
    @JoinColumn(name = "POULE_SCHEDULE_RESULT_MEMBER_ID")
    private MemberEntity member;

    @Column(name = "POULE_SCHEDULE_RESULT_POINTS")
    private Integer points;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PouleScheduleEntity getPouleSchedule() {
        return pouleSchedule;
    }

    public void setPouleSchedule(PouleScheduleEntity pouleSchedule) {
        this.pouleSchedule = pouleSchedule;
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
