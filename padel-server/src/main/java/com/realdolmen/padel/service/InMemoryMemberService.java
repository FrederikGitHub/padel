package com.realdolmen.padel.service;

import com.realdolmen.padel.data.InMemoryDataStore;
import com.realdolmen.padel.model.GroupAvailability;
import com.realdolmen.padel.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("InMemoryMemberService")
public class InMemoryMemberService implements MemberService{

    @Override
    public void addGroupAvailability(Member member,GroupAvailability groupAvailability) {
        Member padelMember = findMember(member);
        padelMember.getGroupAvailability().add(groupAvailability);

        //code te be used for identify duplicates
        /*LinkedHashMultiset<Integer> duplicates = LinkedHashMultiset.create(input);

        // Remove all entries with a count of 1
        duplicates.entrySet().removeIf(entry -> entry.getCount() == 1);

        return duplicates.elementSet();*/
    }

    //private boolean

    @Override
    public void removeGroupAvailability(Member member,GroupAvailability groupAvailability) {
        Member padelMember = findMember(member);
        padelMember.getGroupAvailability().remove(groupAvailability);
    }

    @Override
    public void updateGroupAvailability(Member member, GroupAvailability groupAvailability) {

    }

    @Override
    public List<Member> getPadelMembers() {
        List<Member> padelMembers = InMemoryDataStore.getPadelMembers().stream().filter(Member.Predicates.IS_ACTIVE).sorted().collect(Collectors.toList());
        return padelMembers;
    }

    @Override
    public List<Member> getMemberByName(String name) {
        List<Member> memberList = InMemoryDataStore.getPadelMembers().stream().filter(Member.Predicates.startWithName(name).and(Member.Predicates.IS_ACTIVE)).sorted().collect(Collectors.toList());
        return memberList;
    }

    @Override
    public List<Member> getMemberByFirstName(String firstName) {
        List<Member> memberList = InMemoryDataStore.getPadelMembers().stream().filter(Member.Predicates.startWithFirstName(firstName).and(Member.Predicates.IS_ACTIVE)).sorted().collect(Collectors.toList());
        return memberList;
    }

    @Override
    public List<Member> getMembersForGroupAvailability(String groupName) {
        List<Member> groupMembers = InMemoryDataStore.getPadelMembers().stream().filter(Member.Predicates.withGroup(groupName).and(Member.Predicates.IS_ACTIVE)).sorted().collect(Collectors.toList());
        return groupMembers;
    }

    @Override
    public List<Member> getMembersForLevel(String level) {
        List<Member> groupMembers = InMemoryDataStore.getPadelMembers().stream().filter(Member.Predicates.withGroupLevel(level).and(Member.Predicates.IS_ACTIVE)).sorted().collect(Collectors.toList());
        return groupMembers;
    }


    @Override
    public void create(Member member) {
        InMemoryDataStore.getPadelMembers().add(member);
    }

    @Override
    public void update(Member padelMember) {
        int index = 0;
        for (Member member:InMemoryDataStore.getPadelMembers()){
            if (member.equals(padelMember)){
                break;
            }
            index++;
        }
        InMemoryDataStore.getPadelMembers().set(index,padelMember);
    }

    private Member findMember(Member padelMember){
        Member foundMember=null;
        for (Member member:InMemoryDataStore.getPadelMembers()){
            if (member.equals(padelMember)){
                foundMember = member;
                break;
            }
        }
        return foundMember;
    }

    @Override
    public void delete(Member member) {
        InMemoryDataStore.getPadelMembers().remove(member);
    }
}
