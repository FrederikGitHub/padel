package com.realdolmen.padel.model.builder;

import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.model.Week;

import java.time.LocalDate;

public class WeekBuilder {
    private Integer weekOfYear;
    private Integer weekOfMonth;
    private LocalDate startWeekDay;
    private LocalDate endWeekDay;
    private Integer year;

    public WeekBuilder setWeekOfYear(Integer weekOfYear) {
        this.weekOfYear = weekOfYear;
        return this;
    }

    public WeekBuilder setWeekOfMonth(Integer weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
        return this;
    }

    public WeekBuilder setStartWeekDay(LocalDate startWeekDay) {
        this.startWeekDay = startWeekDay;
        return this;
    }

    public WeekBuilder setEndWeekDay(LocalDate endWeekDay) {
        this.endWeekDay = endWeekDay;
        return this;
    }

    public WeekBuilder setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Week build() {
        return new Week(weekOfYear,weekOfMonth,startWeekDay,endWeekDay,year);
    }
}
