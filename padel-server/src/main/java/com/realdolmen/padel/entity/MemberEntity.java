package com.realdolmen.padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER", schema = "padel")
public class MemberEntity {
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "MEMBER_NAME")
    private String name;

    @Basic
    @Column(name = "MEMBER_FIRST_NAME")
    private String firstName;

    @Basic
    @Column(name = "MEMBER_EMAIL")
    private String email;

    @Basic
    @Column(name = "MEMBER_GSM")
    private String gsm;

    @Basic
    @Column(name = "MEMBER_PASSWORD")
    private String password;

    @ManyToOne
    @JoinColumn(name = "MEMBER_GROUP_ID")
    private GroupEntity group;


    @Basic
    @Column(name = "MEMBER_ACTIVE")
    private String active;

    public MemberEntity() {

    }

    public MemberEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
