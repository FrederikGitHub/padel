package com.realdolmen.padel.model;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Member implements Comparable<Member>{
    private long id;
    private String name;
    private String firstName;
    private String email;
    private String gsm;
    private String level;
    private List<GroupAvailability> groupAvailabilityList;
    private String gender;
    private String active;

    public Member(long id, String name, String firstName, String email, String gsm, List<GroupAvailability> groupAvailabilityList, String level,String gender,String active) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.gsm = gsm;
        this.groupAvailabilityList = groupAvailabilityList;
        this.level = level;
        this.gender = gender;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public Member setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Member setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Member setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGsm() {
        return gsm;
    }

    public Member setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }

    public List<GroupAvailability> getGroupAvailabilityList() {
        return groupAvailabilityList;
    }

    public Member setGroupAvailabilityList(List<GroupAvailability> groupAvailabilityList) {
        this.groupAvailabilityList = groupAvailabilityList;
        return this;
    }

    public String getActive() {
        return active;
    }

    public Member setActive(String active) {
        this.active = active;
        return this;
    }

    public Member setLevel(String level) {
        this.level = level;
        return this;
    }

    public Member setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", gsm='" + gsm + '\'' +
                ", group=" + groupAvailabilityList +
                ", level=" + level +
                ", level=" + gender +
                ", active='" + active + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(name, member.name) &&
                Objects.equals(firstName, member.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstName);
    }

    @Override
    public int compareTo(Member o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.name + " " + this.firstName,o.name + " " + o.firstName);
    }

    public static class Functions {

        public static Function<Member, String> TO_LAST_NAME = new Function<Member, String>() {
            @Override
            public String apply(Member member) {
                return member.getName();
            }
        };

        public static Function<Member, String> TO_FIRST_NAME = new Function<Member, String>() {
            @Override
            public String apply(Member member) {
                return member.getFirstName();
            }
        };

        public static Function<Member, String> TO_FULL_NAME = new Function<Member, String>() {
            @Override
            public String apply(Member member) {
                return member.getName() + " " + member.getFirstName();
            }
        };

        public static Function<Member, Stream<GroupAvailability>> TO_GROUP_AVAILABILITY = new Function<Member, Stream<GroupAvailability>>() {
            @Override
            public Stream<GroupAvailability> apply(Member member) {
                return member.getGroupAvailabilityList().stream();
            }
        };

    }

    public static class Predicates {

        public static final Predicate<Member> withGroup(final String groupName) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getGroupAvailabilityList().stream().map(GroupAvailability::getGroup).anyMatch(Group.Predicates.withGroupName(groupName));
                }
            };
        }

        public static final Predicate<Member> withGroupLevel(final String groupLevel) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getLevel() != null && member.getLevel().equalsIgnoreCase(groupLevel);
                }
            };
        }

        public static final Predicate<Member> withId(final Long id) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getId() == id;
                }
            };
        }


        public static final Predicate<Member> startWithName(final String name) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getName() != null && member.getName().startsWith(name);
                }
            };
        }


        public static final Predicate<Member> IS_ACTIVE = new Predicate<Member>() {
            @Override
            public boolean test(Member member) {
                return member.getActive() == null || member.getActive().equalsIgnoreCase("Y");
            }
        };

        public static final Predicate<Member> startWithFirstName(final String firstName) {
            return new Predicate<Member>() {
                @Override
                public boolean test(Member member) {
                    return member.getName() != null && member.getFirstName().startsWith(firstName);
                }
            };
        }

    }
}
