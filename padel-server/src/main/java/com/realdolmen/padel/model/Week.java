package com.realdolmen.padel.model;

import java.time.LocalDate;
import java.util.Objects;

public class Week implements Comparable<Week>{
    private Integer weekOfYear;
    private Integer weekOfMonth;
    private LocalDate startWeekDay;
    private LocalDate endWeekDay;
    private Integer year;

    public Week() {
    }

    public Week(Integer weekOfYear, Integer weekOfMonth, LocalDate startWeekDay, LocalDate endWeekDay, Integer year) {
        this.weekOfYear = weekOfYear;
        this.weekOfMonth = weekOfMonth;
        this.startWeekDay = startWeekDay;
        this.endWeekDay = endWeekDay;
        this.year = year;
    }

    public Integer getWeekOfYear() {
        return weekOfYear;
    }

    public void setWeekOfYear(Integer weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    public Integer getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setWeekOfMonth(Integer weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public LocalDate getStartWeekDay() {
        return startWeekDay;
    }

    public void setStartWeekDay(LocalDate startWeekDay) {
        this.startWeekDay = startWeekDay;
    }

    public LocalDate getEndWeekDay() {
        return endWeekDay;
    }

    public void setEndWeekDay(LocalDate endWeekDay) {
        this.endWeekDay = endWeekDay;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Week{" +
                "weekOfYear=" + weekOfYear +
                ", weekOfMonth=" + weekOfMonth +
                ", startWeekDay=" + startWeekDay +
                ", endWeekDay=" + endWeekDay +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Week week = (Week) o;
        return Objects.equals(weekOfYear, week.weekOfYear) && Objects.equals(year, week.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weekOfYear, year);
    }

    @Override
    public int compareTo(Week o) {
        if (this.getStartWeekDay().isBefore(o.getStartWeekDay())) {
            return -1;
        } else {
            return 1;
        }
    }
}
