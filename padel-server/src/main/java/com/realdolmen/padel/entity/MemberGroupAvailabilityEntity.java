package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "member_group_availability", schema = "padel")
public class MemberGroupAvailabilityEntity {
    @Id
    @Column(name = "MEMBER_GROUP_AVAILABILITY_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_GROUP_AVAILABILITY_GROUP_ID")
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "MEMBER_GROUP_AVAILABILITY_MEMBER_ID")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "MEMBER_GROUP_AVAILABILITY_AVAILABILITY_ID")
    private AvailabilityEntity availability;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }

    public AvailabilityEntity getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityEntity availability) {
        this.availability = availability;
    }
}
