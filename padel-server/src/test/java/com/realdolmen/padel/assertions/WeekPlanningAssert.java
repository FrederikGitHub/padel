package com.realdolmen.padel.assertions;

import com.realdolmen.padel.model.WeekPlanning;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class WeekPlanningAssert extends AbstractAssert<WeekPlanningAssert, WeekPlanning> {



    WeekPlanningAssert(WeekPlanning actual) {
        super(actual, WeekPlanningAssert.class);


    }

    public static WeekPlanningAssert assertThat(WeekPlanning actual) {
        return new WeekPlanningAssert(actual);
    }

    WeekPlanning getActual() {
        return actual;
    }

    public WeekPlanningAssert hasAtLeastReservationCount(final int minimumReservations) {
        isNotNull();
        Assertions.assertThat(actual.getReservationList().size()).describedAs("Wrong reservation count: ").isGreaterThanOrEqualTo(minimumReservations);
        return this;
    }



}
