package com.realdolmen.padel.model.builder;

import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.Member;

public class MemberBuilder {
    private long id;
    private String name;
    private String firstName;
    private String email;
    private String gsm;
    private Group group;
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

    public MemberBuilder setGroup(Group group) {
        this.group = group;
        return this;
    }

    public MemberBuilder setActive(String active) {
        this.active = active;
        return this;
    }

    public Member build() {
        return new Member(id, name, firstName, email, gsm, group, active);
    }
}
