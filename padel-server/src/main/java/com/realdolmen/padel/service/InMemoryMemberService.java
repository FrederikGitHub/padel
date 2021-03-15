package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.exception.PadelMessageCode;
import com.realdolmen.padel.exception.PadelRuntimeException;
import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.GroupAvailability;
import com.realdolmen.padel.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class InMemoryMemberService implements MemberService {

    @Autowired
    DataStore dataStore;


    @Override
    public List<Member> getPadelMembers() {
        List<Member> padelMembers = dataStore.getPadelMembers().stream().filter(Member.Predicates.IS_ACTIVE).sorted().collect(Collectors.toList());
        return padelMembers;
    }

    @Override
    public List<Member> getPadelGroupMembers(Group group) {
        List<Member> allPadelMembers = getPadelMembers();
        List<Member> padelGroupMembers = allPadelMembers.stream().filter(Member.Predicates.withGroup(group.getName()).and(Member.Predicates.IS_ACTIVE)).collect(Collectors.toList());
        return padelGroupMembers;
    }


    @Override
    public void create(Member member) {
        dataStore.create(member);
    }

    private boolean hasDuplicateAvailability(Member member) {
        //Member existingMember = dataStore.getPadelMembers().stream().filter(Member.Predicates.withId(member.getId())).findFirst().get();
        List<Integer> allWeekNumberListOfMember = member.getGroupAvailabilityList().stream().flatMap(GroupAvailability.Functions.TO_WEEK_NUMBERS).collect(Collectors.toList());
        //List<Integer> weekNumberListOfNewMember = member.getGroupAvailability().stream().flatMap(GroupAvailability.Functions.TO_WEEK_NUMBERS).collect(Collectors.toList());

        //List<Integer> allWeekNumberListOfMember = Stream.concat(weekNumberListOfExistingMember.stream(), weekNumberListOfNewMember.stream()).collect(Collectors.toList());

        List<Integer> duplicates = allWeekNumberListOfMember.stream().collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return duplicates.size() > 0;
    }

    @Override
    public void update(Member padelMember) {

        if (hasDuplicateAvailability(padelMember)) {
            throw new PadelRuntimeException(PadelMessageCode.MEMBER_AVAILABILITY_DUPLICATES);
        }

        dataStore.update(padelMember);
    }

    private Member findMember(Member padelMember) {
        Member foundMember = null;
        for (Member member : dataStore.getPadelMembers()) {
            if (member.equals(padelMember)) {
                foundMember = member;
                break;
            }
        }
        return foundMember;
    }

    @Override
    public void delete(Member member) {
        dataStore.delete(member);
    }


    @Override
    public List<Member> getMembersForGroupAvailability(String groupName) {
        List<Member> groupMembers = dataStore.getPadelMembers().stream().filter(Member.Predicates.withGroup(groupName).and(Member.Predicates.IS_ACTIVE)).sorted().collect(Collectors.toList());
        return groupMembers;
    }
}
