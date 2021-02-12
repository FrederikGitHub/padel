package com.realdolmen.padel.model.builder;

import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.model.GroupAvailability;

import java.util.List;

public class MemberBuilder {
    private long id;
    private String name;
    private String firstName;
    private String email;
    private String gsm;
    private List<GroupAvailability> groupAvailabilityList;
    private Group level;
    private String active;

    public MemberBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public MemberBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberBuilder setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }

    public MemberBuilder setGroupAvailabilityList(List<GroupAvailability> groupAvailabilityList) {
        this.groupAvailabilityList = groupAvailabilityList;
        return this;
    }

    public MemberBuilder setActive(String active) {
        this.active = active;
        return this;
    }

    public MemberBuilder setLevel(Group level) {
        this.level = level;
        return this;
    }

    public Member build() {
        return new Member(id, name, firstName, email, gsm, groupAvailabilityList, level,active);
    }
}
