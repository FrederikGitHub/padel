package com.realdolmen.padel.service;

import com.realdolmen.padel.model.GroupAvailability;
import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.model.PouleTourGame;

import java.util.List;

public interface MemberService {

    public List<Member> getPadelMembers();

    public void addGroupAvailability(Member member,GroupAvailability groupAvailability);

    public void updateGroupAvailability(Member member,GroupAvailability groupAvailability);

    public void removeGroupAvailability(Member member,GroupAvailability groupAvailability);

    public List<Member> getMemberByName(String name);

    public List<Member> getMemberByFirstName(String name);

    public List<Member> getMembersForGroupAvailability(String groupName);

    public List<Member> getMembersForLevel(String level);

    void create(Member member);

    void update(Member member);

    void delete(Member member);
}
