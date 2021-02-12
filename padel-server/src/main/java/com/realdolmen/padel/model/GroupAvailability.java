package com.realdolmen.padel.model;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class GroupAvailability {
    private List<Integer> weekNumbersOfMonth;
    private Group group;

    public GroupAvailability(List<Integer> weekNumbersOfMonth, Group group) {
        this.weekNumbersOfMonth = weekNumbersOfMonth;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Integer> getWeekNumbersOfMonth() {
        return weekNumbersOfMonth;
    }

    public void setWeekNumbersOfMonth(List<Integer> weekNumbersOfMonth) {
        this.weekNumbersOfMonth = weekNumbersOfMonth;
    }

    @Override
    public String toString() {
        return "MemberPercentageGroup{" +
                "percentage=" + weekNumbersOfMonth +
                ", group=" + group +
                '}';
    }

    public static class Functions {

        public static Function<GroupAvailability, Group> TO_GROUP = new Function<GroupAvailability, Group>() {
            @Override
            public Group apply(GroupAvailability groupAvailability) {
                return groupAvailability.getGroup();
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
