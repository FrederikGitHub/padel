package com.realdolmen.padel.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name =  "\"member\"", schema = "padel")
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

    @Basic
    @Column(name = "MEMBER_GENDER")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "MEMBER_VTV_LEVEL")
    private VtvLevelEntity vtvLevel;

    @OneToMany(mappedBy="member",cascade = CascadeType.PERSIST)
    private Set<MemberGroupAvailabilityEntity> groupAvailabilityList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reservation_member", joinColumns = {
            @JoinColumn(name = "RESERVATION_MEMBER_MEMBER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "RESERVATION_MEMBER_RESERVATION_ID")})
    private Set<ReservationEntity> reservationEntitySet;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setVtvLevel(VtvLevelEntity vtvLevel) {
        this.vtvLevel = vtvLevel;
    }

    public VtvLevelEntity getVtvLevel() {
        return vtvLevel;
    }

    public Set<MemberGroupAvailabilityEntity> getGroupAvailabilityList() {
        return groupAvailabilityList;
    }

    public void setGroupAvailabilityList(Set<MemberGroupAvailabilityEntity> groupAvailabilityList) {
        this.groupAvailabilityList = groupAvailabilityList;
    }

    public Set<ReservationEntity> getReservationEntitySet() {
        return reservationEntitySet;
    }

    public void setReservationEntitySet(Set<ReservationEntity> reservationEntitySet) {
        this.reservationEntitySet = reservationEntitySet;
    }
}
