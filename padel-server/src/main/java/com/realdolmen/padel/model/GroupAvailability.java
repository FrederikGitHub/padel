package com.realdolmen.padel.model;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class GroupAvailability {
    private Availability availability;
    private Group group;

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
