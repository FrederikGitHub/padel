package com.realdolmen.padel.model;

import java.util.Arrays;
import java.util.List;

public enum Availability {

    FIRST_WEEK_AVAILABILITY("25% (week1)",Arrays.asList(1)),
    SECOND_WEEK_AVAILABILITY("25% (week2)",Arrays.asList(2)),
    THIRD_WEEK_AVAILABILITY("25% (week3)",Arrays.asList(3)),
    FOURTH_WEEK_AVAILABILITY("25% (week4)",Arrays.asList(4)),

    FIRST_SECOND_WEEK_AVAILABILITY("50% (week1,week2)",Arrays.asList(1,2)),
    FIRST_THIRD_WEEK_AVAILABILITY("50% (week1,week3)",Arrays.asList(1,3)),
    FIRST_FOURTH_WEEK_AVAILABILITY("50% (week1,week4)",Arrays.asList(1,4)),
    SECOND_FOURTH_WEEK_AVAILABILITY("50% (week2,week4)",Arrays.asList(2,4)),
    SECOND_THIRD_WEEK_AVAILABILITY("50% (week2,week3)",Arrays.asList(2,3)),
    THIRD_FOURTH_WEEK_AVAILABILITY("50% (week3,week4)",Arrays.asList(3,4)),
    THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY("50%+ (week3,week4,week5)",Arrays.asList(3,4,5)),
    SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY("50%+ (week2,week4,week5)",Arrays.asList(2,4,5)),
    SECOND_THIRD_FIFTH_WEEK_AVAILABILITY("50%+ (week2,week3,week5)",Arrays.asList(2,3,5)),
    FIRST_THIRD_FIFTH_WEEK_AVAILABILITY("50%+ (week1,week3,week5)",Arrays.asList(1,3,5)),
    FIRST_FOURTH_FIFTH_WEEK_AVAILABILITY("50%+ (week1,week4,week5)",Arrays.asList(1,4,5)),
    FIRST_SECOND_FIFTH_WEEK_AVAILABILITY("50%+ (week1,week2,week5)",Arrays.asList(1,2,5)),

    SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY("75% (week2,week3,week4,week5)",Arrays.asList(2,3,4,5)),
    FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY("75% (week1,week3,week4,week5)",Arrays.asList(1,3,4,5)),
    FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY("75% (week1,week2,week4,week5)",Arrays.asList(1,2,4,5)),
    FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY("75% (week1,week2,week3,week5)",Arrays.asList(1,2,3,5)),

    FULL_TIME_AVAILABILITY("100%",Arrays.asList(1,2,3,4,5));

    private final String label;
    private final List<Integer> weekNumbers;


    private Availability(String label, List<Integer> weekNumbers) {
        this.label = label;
        this.weekNumbers = weekNumbers;
    }

    public String getLabel() {
        return label;
    }

    public List<Integer> getWeekNumbers() {
        return weekNumbers;
    }
}
