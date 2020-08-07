package com.realdolmen.padel.model;

import java.util.Objects;

public class Member {
    private long id;
    private String name;
    private String firstName;
    private String email;
    private String gsm;
    private Group group;
    private String active;

    public Member(long id, String name, String firstName, String email, String gsm, Group group, String active) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.gsm = gsm;
        this.group = group;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public Member setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Member setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Member setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGsm() {
        return gsm;
    }

    public Member setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public Member setGroup(Group group) {
        this.group = group;
        return this;
    }

    public String getActive() {
        return active;
    }

    public Member setActive(String active) {
        this.active = active;
        return this;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", gsm='" + gsm + '\'' +
                ", group=" + group +
                ", active='" + active + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(name, member.name) &&
                Objects.equals(firstName, member.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstName);
    }
}
