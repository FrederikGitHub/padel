package com.realdolmen.padel.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.realdolmen.padel.entity.ReservationTypeEntity;
import com.realdolmen.padel.entity.TimeSlotEntity;

import java.time.DayOfWeek;
import java.util.function.Function;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TimeSlot {
    TIME_SLOT_MONDAY_0800_0930(1L,DayOfWeek.MONDAY,"08:00","09:30"),
    TIME_SLOT_MONDAY_0930_1100(2L,DayOfWeek.MONDAY,"09:30","11:00"),
    TIME_SLOT_MONDAY_1100_1230(3L,DayOfWeek.MONDAY,"11:00","12:30"),
    TIME_SLOT_MONDAY_1230_1400(4L,DayOfWeek.MONDAY,"12:30","14:00"),
    TIME_SLOT_MONDAY_1400_1530(5L,DayOfWeek.MONDAY,"14:00","15:30"),
    TIME_SLOT_MONDAY_1530_1700(6L,DayOfWeek.MONDAY,"15:30","17:00"),
    TIME_SLOT_MONDAY_1700_1830(7L,DayOfWeek.MONDAY,"17:00","18:30"),
    TIME_SLOT_MONDAY_1830_2000(8L,DayOfWeek.MONDAY,"18:30","20:00"),
    TIME_SLOT_MONDAY_2000_2130(9L,DayOfWeek.MONDAY,"20:00","21:30"),
    TIME_SLOT_MONDAY_2130_2300(10L,DayOfWeek.MONDAY,"21:30","23:00"),

    TIME_SLOT_TUESDAY_0800_0930(11L,DayOfWeek.TUESDAY,"08:00","09:30"),
    TIME_SLOT_TUESDAY_0930_1100(12L,DayOfWeek.TUESDAY,"09:30","11:00"),
    TIME_SLOT_TUESDAY_1100_1230(13L,DayOfWeek.TUESDAY,"11:00","12:30"),
    TIME_SLOT_TUESDAY_1230_1400(14L,DayOfWeek.TUESDAY,"12:30","14:00"),
    TIME_SLOT_TUESDAY_1400_1530(15L,DayOfWeek.TUESDAY,"14:00","15:30"),
    TIME_SLOT_TUESDAY_1530_1700(16L,DayOfWeek.TUESDAY,"15:30","17:00"),
    TIME_SLOT_TUESDAY_1700_1830(17L,DayOfWeek.TUESDAY,"17:00","18:30"),
    TIME_SLOT_TUESDAY_1830_2000(18L,DayOfWeek.TUESDAY,"18:30","20:00"),
    TIME_SLOT_TUESDAY_2000_2130(19L,DayOfWeek.TUESDAY,"20:00","21:30"),
    TIME_SLOT_TUESDAY_2130_2300(20L,DayOfWeek.TUESDAY,"21:30","23:00"),

    TIME_SLOT_WEDNESDAY_0800_0930(21L,DayOfWeek.WEDNESDAY,"08:00","09:30"),
    TIME_SLOT_WEDNESDAY_0930_1100(22L,DayOfWeek.WEDNESDAY,"09:30","11:00"),
    TIME_SLOT_WEDNESDAY_1100_1230(23L,DayOfWeek.WEDNESDAY,"11:00","12:30"),
    TIME_SLOT_WEDNESDAY_1230_1400(24L,DayOfWeek.WEDNESDAY,"12:30","14:00"),
    TIME_SLOT_WEDNESDAY_1400_1530(25L,DayOfWeek.WEDNESDAY,"14:00","15:30"),
    TIME_SLOT_WEDNESDAY_1530_1700(26L,DayOfWeek.WEDNESDAY,"15:30","17:00"),
    TIME_SLOT_WEDNESDAY_1700_1830(27L,DayOfWeek.WEDNESDAY,"17:00","18:30"),
    TIME_SLOT_WEDNESDAY_1830_2000(28L,DayOfWeek.WEDNESDAY,"18:30","20:00"),
    TIME_SLOT_WEDNESDAY_2000_2130(29L,DayOfWeek.WEDNESDAY,"20:00","21:30"),
    TIME_SLOT_WEDNESDAY_2130_2300(30L,DayOfWeek.WEDNESDAY,"21:30","23:00"),


    TIME_SLOT_THURSDAY_0800_0930(31L,DayOfWeek.THURSDAY,"08:00","09:30"),
    TIME_SLOT_THURSDAY_0930_1100(32L,DayOfWeek.THURSDAY,"09:30","11:00"),
    TIME_SLOT_THURSDAY_1100_1230(33L,DayOfWeek.THURSDAY,"11:00","12:30"),
    TIME_SLOT_THURSDAY_1230_1400(34L,DayOfWeek.THURSDAY,"12:30","14:00"),
    TIME_SLOT_THURSDAY_1400_1530(35L,DayOfWeek.THURSDAY,"14:00","15:30"),
    TIME_SLOT_THURSDAY_1530_1700(36L,DayOfWeek.THURSDAY,"15:30","17:00"),
    TIME_SLOT_THURSDAY_1700_1830(37L,DayOfWeek.THURSDAY,"17:00","18:30"),
    TIME_SLOT_THURSDAY_1830_2000(38L,DayOfWeek.THURSDAY,"18:30","20:00"),
    TIME_SLOT_THURSDAY_2000_2130(39L,DayOfWeek.THURSDAY,"20:00","21:30"),
    TIME_SLOT_THURSDAY_2130_2300(40L,DayOfWeek.THURSDAY,"21:30","23:00"),

    TIME_SLOT_FRIDAY_0800_0930(41L,DayOfWeek.FRIDAY,"08:00","09:30"),
    TIME_SLOT_FRIDAY_0930_1100(42L,DayOfWeek.FRIDAY,"09:30","11:00"),
    TIME_SLOT_FRIDAY_1100_1230(43L,DayOfWeek.FRIDAY,"11:00","12:30"),
    TIME_SLOT_FRIDAY_1230_1400(44L,DayOfWeek.FRIDAY,"12:30","14:00"),
    TIME_SLOT_FRIDAY_1400_1530(45L,DayOfWeek.FRIDAY,"14:00","15:30"),
    TIME_SLOT_FRIDAY_1530_1700(46L,DayOfWeek.FRIDAY,"15:30","17:00"),
    TIME_SLOT_FRIDAY_1700_1830(47L,DayOfWeek.FRIDAY,"17:00","18:30"),
    TIME_SLOT_FRIDAY_1830_2000(48L,DayOfWeek.FRIDAY,"18:30","20:00"),
    TIME_SLOT_FRIDAY_2000_2130(49L,DayOfWeek.FRIDAY,"20:00","21:30"),
    TIME_SLOT_FRIDAY_2130_2300(50L,DayOfWeek.FRIDAY,"21:30","23:00"),

    TIME_SLOT_SATURDAY_0800_0930(51L,DayOfWeek.SATURDAY,"08:00","09:30"),
    TIME_SLOT_SATURDAY_0930_1100(52L,DayOfWeek.SATURDAY,"09:30","11:00"),
    TIME_SLOT_SATURDAY_1100_1230(53L,DayOfWeek.SATURDAY,"11:00","12:30"),
    TIME_SLOT_SATURDAY_1230_1400(54L,DayOfWeek.SATURDAY,"12:30","14:00"),
    TIME_SLOT_SATURDAY_1400_1530(55L,DayOfWeek.SATURDAY,"14:00","15:30"),
    TIME_SLOT_SATURDAY_1530_1700(56L,DayOfWeek.SATURDAY,"15:30","17:00"),
    TIME_SLOT_SATURDAY_1700_1830(57L,DayOfWeek.SATURDAY,"17:00","18:30"),
    TIME_SLOT_SATURDAY_1830_2000(58L,DayOfWeek.SATURDAY,"18:30","20:00"),
    TIME_SLOT_SATURDAY_2000_2130(59L,DayOfWeek.SATURDAY,"20:00","21:30"),
    TIME_SLOT_SATURDAY_2130_2300(60L,DayOfWeek.SATURDAY,"21:30","23:00"),

    TIME_SLOT_SUNDAY_0800_0930(61L,DayOfWeek.SUNDAY,"08:00","09:30"),
    TIME_SLOT_SUNDAY_0930_1100(62L,DayOfWeek.SUNDAY,"09:30","11:00"),
    TIME_SLOT_SUNDAY_1100_1230(63L,DayOfWeek.SUNDAY,"11:00","12:30"),
    TIME_SLOT_SUNDAY_1230_1400(64L,DayOfWeek.SUNDAY,"12:30","14:00"),
    TIME_SLOT_SUNDAY_1400_1530(65L,DayOfWeek.SUNDAY,"14:00","15:30"),
    TIME_SLOT_SUNDAY_1530_1700(66L,DayOfWeek.SUNDAY,"15:30","17:00"),
    TIME_SLOT_SUNDAY_1700_1830(67L,DayOfWeek.SUNDAY,"17:00","18:30"),
    TIME_SLOT_SUNDAY_1830_2000(68L,DayOfWeek.SUNDAY,"18:30","20:00"),
    TIME_SLOT_SUNDAY_2000_2130(69L,DayOfWeek.SUNDAY,"20:00","21:30"),
    TIME_SLOT_SUNDAY_2130_2300(70L,DayOfWeek.SUNDAY,"21:30","23:00");

    private final Long id;
    private final String from;
    private final String to;
    private final DayOfWeek dayOfWeek;

    private TimeSlot(Long id,DayOfWeek dayOfWeek,String from,String to) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.dayOfWeek = dayOfWeek;
    }


    public String getFrom() {
        return from;
    }


    public String getTo() {
        return to;
    }


    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Long getId() {
        return id;
    }

    @JsonCreator
    public static TimeSlot forValues(@JsonProperty("from") String from,
                                         @JsonProperty("to") String to, @JsonProperty("dayOfWeek") DayOfWeek dayOfWeek) {
        for (TimeSlot timeSlot : TimeSlot.values()) {
            if (
                    timeSlot.getFrom().equalsIgnoreCase(from) && timeSlot.getTo().equalsIgnoreCase(to) && timeSlot.getDayOfWeek().equals(dayOfWeek)) {
                return timeSlot;
            }
        }

        return null;
    }

    public static class Functions {

        public static Function<TimeSlotEntity, TimeSlot> FROM_TIMESLOT_ENTITY = new Function<TimeSlotEntity, TimeSlot>() {
            @Override
            public TimeSlot apply(TimeSlotEntity timeSlotEntity) {
                TimeSlot timeSlot = TimeSlot.forValues(timeSlotEntity.getFrom(),timeSlotEntity.getTo(),DayOfWeek.of((int)timeSlotEntity.getWeekday().getId()));
                return timeSlot;
            }
        };

    }



}
