package com.realdolmen.padel.service;

import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.Member;

import java.util.List;

public interface MemberService {

    public List<Member> getPadelMembers();

    public List<Member> getPadelGroupMembers(Group group);

    void create(Member member);

    void update(Member member);

    void delete(Member member);

    List<Member> getMembersForGroupAvailability(String groupName);
}
