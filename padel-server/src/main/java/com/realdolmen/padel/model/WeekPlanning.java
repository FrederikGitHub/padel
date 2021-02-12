package com.realdolmen.padel.model;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class WeekPlanning implements Comparable<WeekPlanning> {
    private Week week;
    public List<Reservation> reservationList;
    public List<Member> reserveList;

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;

    }

    public List<Member> getReserveList() {
        return reserveList;
    }

    public void setReserveList(List<Member> reserveList) {
        this.reserveList = reserveList;

    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "WeekPlanning{" +
                "reservationList=" + reservationList +
                ", reserveList=" + reserveList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeekPlanning that = (WeekPlanning) o;
        return Objects.equals(week, that.week);
    }

    @Override
    public int hashCode() {
        return Objects.hash(week);
    }

    @Override
    public int compareTo(WeekPlanning weekPlanning) {
        if (this.getWeek().getStartWeekDay().isBefore(weekPlanning.getWeek().getStartWeekDay())) {
            return -1;
        } else {
            return 1;
        }

    }

    public static class Functions {

        public static Function<WeekPlanning, Stream<Reservation>> TO_RESERVATIONS = new Function<WeekPlanning, Stream<Reservation>>() {
            @Override
            public Stream<Reservation> apply(WeekPlanning weekPlanning) {
                return weekPlanning.getReservationList().stream();
            }
        };

    }
}
