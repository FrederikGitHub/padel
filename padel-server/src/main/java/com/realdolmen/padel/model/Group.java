package com.realdolmen.padel.model;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Group implements Comparable<Group> {
    private long id;
    private String name;
    private String active;
    private String vtvLevel;

    public Group(long id, String name, String vtvLevel) {
        this.id = id;
        this.name = name;
        this.vtvLevel = vtvLevel;
    }

    public long getId() {
        return id;
    }

    public Group setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getActive() {
        return active;
    }

    public Group setActive(String active) {
        this.active = active;
        return this;
    }

    public Group setVtvLevel(String vtvLevel) {
        this.vtvLevel = vtvLevel;
        return this;
    }

    public String getVtvLevel() {
        return vtvLevel;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                "name=" + id +
                "vtvLevel=" + vtvLevel +
                "active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Group o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.name, o.name);
    }


    public static class Predicates {

        public static final Predicate<Group> withGroupName(final String groupName) {
            return new Predicate<Group>() {
                @Override
                public boolean test(Group group) {
                    return group.getName() != null && group.getName().equalsIgnoreCase(groupName);
                }
            };
        }

        public static final Predicate<Group> IS_ACTIVE = new Predicate<Group>() {
            @Override
            public boolean test(Group group) {
                return group.getActive() == null || group.getActive().equalsIgnoreCase("Y");
            }
        };

    }

    public static class Functions {

        public static Function<Group, String> TO_GROUP_NAME = new Function<Group, String>() {
            @Override
            public String apply(Group group) {
                return group.getName();
            }
        };

    }


}
