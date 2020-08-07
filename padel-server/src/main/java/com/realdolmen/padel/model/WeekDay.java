package com.realdolmen.padel.model;

import java.util.Objects;

public class WeekDay {

    private long id;

    private long dayOfWeek;

    private String name;

    public WeekDay(long id, long dayOfWeek, String name) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public WeekDay setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public WeekDay setName(String name) {
        this.name = name;
        return this;
    }

    public long getDayOfWeek() {
        return dayOfWeek;
    }

    public WeekDay setDayOfWeek(long dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    @Override
    public String toString() {
        return "WeekDay{" +
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeekDay weekDay = (WeekDay) o;
        return id == weekDay.id &&
                dayOfWeek == weekDay.dayOfWeek &&
                Objects.equals(name, weekDay.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayOfWeek, name);
    }
}
