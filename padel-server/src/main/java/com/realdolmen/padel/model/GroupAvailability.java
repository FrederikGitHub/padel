package com.realdolmen.padel.model;

import com.realdolmen.padel.entity.MemberGroupAvailabilityEntity;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class GroupAvailability {
    private Availability availability;
    private Group group;

    public GroupAvailability() {

    }

    public GroupAvailability(Availability availability, Group group) {
        this.availability = availability;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }



    public static class Functions {

        public static Function<GroupAvailability, Group> TO_GROUP = new Function<GroupAvailability, Group>() {
            @Override
            public Group apply(GroupAvailability groupAvailability) {
                return groupAvailability.getGroup();
            }
        };

        public static Function<GroupAvailability, Stream<Integer>> TO_WEEK_NUMBERS = new Function<GroupAvailability, Stream<Integer>>() {
            @Override
            public Stream<Integer> apply(GroupAvailability groupAvailability) {
                return groupAvailability.getAvailability().getWeekNumbers().stream();
            }
        };

        public static Function<GroupAvailability, MemberGroupAvailabilityEntity> TO_MEMBER_GROUP_AVAILABILITY_ENTITY = new Function<GroupAvailability, MemberGroupAvailabilityEntity>() {
            @Override
            public MemberGroupAvailabilityEntity apply(GroupAvailability groupAvailability) {
                MemberGroupAvailabilityEntity memberGroupAvailabilityEntity = new MemberGroupAvailabilityEntity();
                //memberGroupAvailabilityEntity.setMember(groupAvailability.getMember());
                if (groupAvailability.getAvailability() != null){
                    memberGroupAvailabilityEntity.setAvailability(Availability.Functions.TO_AVAILABILITY_ENTITY.apply(groupAvailability.getAvailability()));
                }
                if (groupAvailability.getGroup() != null){
                    memberGroupAvailabilityEntity.setGroup(Group.Functions.TO_GROUP_ENTITY.apply(groupAvailability.getGroup()));
                }
                return memberGroupAvailabilityEntity;
            }
        };

        public static Function<MemberGroupAvailabilityEntity, GroupAvailability> FROM_MEMBER_GROUP_AVAILABILITY_ENTITY = new Function<MemberGroupAvailabilityEntity, GroupAvailability>() {
            @Override
            public GroupAvailability apply(MemberGroupAvailabilityEntity memberGroupAvailabilityEntity) {
                GroupAvailability groupAvailability = new GroupAvailability();
                //memberGroupAvailabilityEntity.setMember(groupAvailability.getMember());
                if (memberGroupAvailabilityEntity.getAvailability() != null){
                    groupAvailability.setAvailability(Availability.Functions.FROM_AVAILABILITY_ENTITY.apply(memberGroupAvailabilityEntity.getAvailability()));
                }
                if (memberGroupAvailabilityEntity.getGroup() != null){
                    groupAvailability.setGroup(Group.Functions.FROM_GROUP_ENTITY.apply(memberGroupAvailabilityEntity.getGroup()));
                }
                return groupAvailability;
            }
        };

    }


    public static class Predicates {

        public static final Predicate<GroupAvailability> withGroup(final Group group) {
            return new Predicate<GroupAvailability>() {
                @Override
                public boolean test(GroupAvailability groupAvailability) {
                    return groupAvailability.getGroup().getName().equalsIgnoreCase(group.getName());
                }

                ;
            };

        }

    }
}
