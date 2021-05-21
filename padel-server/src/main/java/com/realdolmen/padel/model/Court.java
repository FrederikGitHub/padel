package com.realdolmen.padel.model;


import com.realdolmen.padel.entity.CourtEntity;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Court implements Comparable<Court> {
    private long id;
    private String name;

    public Court() {

    }

    public Court(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Court setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Court setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Court{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Court court = (Court) o;
        return Objects.equals(name, court.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Court o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.name, o.name);
    }

    public static class Predicates {

        public static final Predicate<Court> withId(final Long id) {
            return new Predicate<Court>() {
                @Override
                public boolean test(Court court) {
                    return court.getId() == id;
                }
            };
        }

        public static final Predicate<Court> withName(final String name) {
            return new Predicate<Court>() {
                @Override
                public boolean test(Court court) {
                    return court.getName().equalsIgnoreCase(name);
                }
            };
        }
    }

    public static class Functions {

        public static Function<CourtEntity, Court> FROM_COURT_ENTITY = new Function<CourtEntity, Court>() {
            @Override
            public Court apply(CourtEntity courtEntity) {
                Court court = new Court();
                court.setId(courtEntity.getId());
                court.setName(courtEntity.getName());
                return court;
            }
        };

        public static Function<Court, CourtEntity> TO_COURT_ENTITY = new Function<Court, CourtEntity>() {
            @Override
            public CourtEntity apply(Court court) {
                CourtEntity courtEntity = new CourtEntity();
                courtEntity.setId(court.getId());
                courtEntity.setName(court.getName());
                return courtEntity;
            }
        };

    }
}
