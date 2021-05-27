package com.realdolmen.padel.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.realdolmen.padel.entity.AvailabilityEntity;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Availability {

    FIRST_WEEK_AVAILABILITY(1L, "25% (week1)", Arrays.asList(1)),
    SECOND_WEEK_AVAILABILITY(2L, "25% (week2)", Arrays.asList(2)),
    THIRD_WEEK_AVAILABILITY(3L, "25% (week3)", Arrays.asList(3)),
    FOURTH_WEEK_AVAILABILITY(4L, "25% (week4)", Arrays.asList(4)),

    FIRST_SECOND_WEEK_AVAILABILITY(5L, "50% (week1,week2)", Arrays.asList(1, 2)),
    FIRST_THIRD_WEEK_AVAILABILITY(6L, "50% (week1,week3)", Arrays.asList(1, 3)),
    FIRST_FOURTH_WEEK_AVAILABILITY(7L, "50% (week1,week4)", Arrays.asList(1, 4)),
    SECOND_FOURTH_WEEK_AVAILABILITY(8L, "50% (week2,week4)", Arrays.asList(2, 4)),
    SECOND_THIRD_WEEK_AVAILABILITY(9L, "50% (week2,week3)", Arrays.asList(2, 3)),
    THIRD_FOURTH_WEEK_AVAILABILITY(10L, "50% (week3,week4)", Arrays.asList(3, 4)),
    THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY(11L, "50%+ (week3,week4,week5)", Arrays.asList(3, 4, 5)),
    SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY(12L, "50%+ (week2,week4,week5)", Arrays.asList(2, 4, 5)),
    SECOND_THIRD_FIFTH_WEEK_AVAILABILITY(13L, "50%+ (week2,week3,week5)", Arrays.asList(2, 3, 5)),
    FIRST_THIRD_FIFTH_WEEK_AVAILABILITY(14L, "50%+ (week1,week3,week5)", Arrays.asList(1, 3, 5)),
    FIRST_FOURTH_FIFTH_WEEK_AVAILABILITY(15L, "50%+ (week1,week4,week5)", Arrays.asList(1, 4, 5)),
    FIRST_SECOND_FIFTH_WEEK_AVAILABILITY(16L, "50%+ (week1,week2,week5)", Arrays.asList(1, 2, 5)),

    SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY(17L, "75% (week2,week3,week4,week5)", Arrays.asList(2, 3, 4, 5)),
    FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY(18L, "75% (week1,week3,week4,week5)", Arrays.asList(1, 3, 4, 5)),
    FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY(19L, "75% (week1,week2,week4,week5)", Arrays.asList(1, 2, 4, 5)),
    FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY(20L, "75% (week1,week2,week3,week5)", Arrays.asList(1, 2, 3, 5)),

    FULL_TIME_AVAILABILITY(21L, "100%", Arrays.asList(1, 2, 3, 4, 5));

    private final Long id;
    private final String label;
    private final List<Integer> weekNumbers;


    private Availability(Long id, String label, List<Integer> weekNumbers) {
        this.id = id;
        this.label = label;
        this.weekNumbers = weekNumbers;
    }


    public String getLabel() {
        return label;
    }


    public List<Integer> getWeekNumbers() {
        return weekNumbers;
    }


    public Long getId() {
        return id;
    }

    @JsonCreator
    public static Availability forValues(@JsonProperty("id") Long id,
                                         @JsonProperty("label") String label, @JsonProperty("weekNumbers") List<Integer> weekNumbers) {
        for (Availability availability : Availability.values()) {
            if (
                    availability.getId().equals(id) && availability.getLabel().equalsIgnoreCase(label)) {
                return availability;
            }
        }

        return null;
    }

    public static class Functions {

        public static Function<AvailabilityEntity, Availability> FROM_AVAILABILITY_ENTITY = new Function<AvailabilityEntity, Availability>() {
            @Override
            public Availability apply(AvailabilityEntity availabilityEntity) {
                List<Integer> weekNumbers = new ArrayList<Integer>();

                /*String[] elements = csv.split(",");

                List<String> fixedLenghtList = Arrays.asList(elements);

                intList.addAll(strList.stream().map(Integer::valueOf).collect(Collectors.toList()));*/


                if (StringUtils.isNotEmpty(availabilityEntity.getWeekNumbers())) {
                    weekNumbers = new ArrayList<String>(Arrays.asList(availabilityEntity.getWeekNumbers().split(","))).stream().map(Integer::valueOf).collect(Collectors.toList());
                }
                return Availability.forValues(availabilityEntity.getId(), availabilityEntity.getLabel(), weekNumbers);
            }
        };

        public static Function<Availability, AvailabilityEntity> TO_AVAILABILITY_ENTITY = new Function<Availability, AvailabilityEntity>() {
            @Override
            public AvailabilityEntity apply(Availability availability) {
                AvailabilityEntity availabilityEntity = new AvailabilityEntity();
                availabilityEntity.setId(availability.getId());
                if (!CollectionUtils.isEmpty(availability.getWeekNumbers())) {
                    String weekNumbers = String.join(",", availability.getWeekNumbers().stream().map(String::valueOf).collect(Collectors.toList()));
                    availabilityEntity.setWeekNumbers(weekNumbers);
                }
                availabilityEntity.setLabel(availability.getLabel());
                return availabilityEntity;
            }
        };

    }


}
