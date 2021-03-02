package com.realdolmen.padel.service;

import com.realdolmen.padel.model.Member;

import java.util.List;

public interface MemberService {

    public List<Member> getPadelMembers();

    void create(Member member);

    void update(Member member);

    void delete(Member member);

    List<Member> getMembersForGroupAvailability(String groupName);
}
