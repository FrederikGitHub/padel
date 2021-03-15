package com.realdolmen.padel.model;

import io.micrometer.core.instrument.util.StringUtils;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Week implements Comparable<Week>{
    private Integer weekOfYear;
    private Integer weekOfMonth;
    private LocalDate startWeekDay;
    private LocalDate endWeekDay;
    private Integer year;

    public Week() {
    }


    public Week(Integer weekOfYear) {
        this.weekOfYear = weekOfYear;
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


    public static class Functions {

        public static Function<String, Week> FROM_WEEK_KEY = new Function<String, Week>() {
            @Override
            public Week apply(String weekKey) {
                String[] weekKeyList = weekKey.split(";");
                Week week = new Week();
                if (weekKeyList.length>1 && StringUtils.isNotEmpty(weekKeyList[1])){
                    LocalDate fromDate = LocalDate.parse(weekKeyList[1]);
                    week.setStartWeekDay(fromDate);
                }
                if (weekKeyList.length>2 && StringUtils.isNotEmpty(weekKeyList[2])){
                    LocalDate toDate = LocalDate.parse(weekKeyList[2]);
                    week.setStartWeekDay(toDate);
                }
                if (weekKeyList.length>3 && StringUtils.isNotEmpty(weekKeyList[3])){
                    week.setWeekOfYear(new Integer(weekKeyList[3]));
                }
                if (weekKeyList.length>4 && StringUtils.isNotEmpty(weekKeyList[4])){
                    week.setWeekOfMonth(new Integer(weekKeyList[4]));
                }
                if (weekKeyList.length>5 && StringUtils.isNotEmpty(weekKeyList[5])){
                    week.setYear(new Integer(weekKeyList[5]));
                }


                return week;
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
}
