package com.realdolmen.padel.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.DayOfWeek;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TimeSlot {
    TIME_SLOT_MONDAY_0630_0800(DayOfWeek.MONDAY,"06:30","08:00"),
    TIME_SLOT_MONDAY_0800_0930(DayOfWeek.MONDAY,"08:00","09:30"),
    TIME_SLOT_MONDAY_0930_1100(DayOfWeek.MONDAY,"09:30","11:00"),
    TIME_SLOT_MONDAY_1100_1230(DayOfWeek.MONDAY,"11:00","12:00"),
    TIME_SLOT_MONDAY_1230_1400(DayOfWeek.MONDAY,"12:30","14:00"),
    TIME_SLOT_MONDAY_1400_1530(DayOfWeek.MONDAY,"14:00","15:30"),
    TIME_SLOT_MONDAY_1530_1700(DayOfWeek.MONDAY,"15:30","17:00"),
    TIME_SLOT_MONDAY_1700_1830(DayOfWeek.MONDAY,"17:00","18:30"),
    TIME_SLOT_MONDAY_1830_2000(DayOfWeek.MONDAY,"18:30","20:00"),
    TIME_SLOT_MONDAY_2000_2130(DayOfWeek.MONDAY,"20:00","21:30"),
    TIME_SLOT_MONDAY_2130_2300(DayOfWeek.MONDAY,"21:30","23:00"),

    TIME_SLOT_TUESDAY_0630_0800(DayOfWeek.TUESDAY,"06:30","08:00"),
    TIME_SLOT_TUESDAY_0800_0930(DayOfWeek.TUESDAY,"08:00","09:30"),
    TIME_SLOT_TUESDAY_0930_1100(DayOfWeek.TUESDAY,"09:30","11:00"),
    TIME_SLOT_TUESDAY_1100_1230(DayOfWeek.TUESDAY,"11:00","12:00"),
    TIME_SLOT_TUESDAY_1230_1400(DayOfWeek.TUESDAY,"12:30","14:00"),
    TIME_SLOT_TUESDAY_1400_1530(DayOfWeek.TUESDAY,"14:00","15:30"),
    TIME_SLOT_TUESDAY_1530_1700(DayOfWeek.TUESDAY,"15:30","17:00"),
    TIME_SLOT_TUESDAY_1700_1830(DayOfWeek.TUESDAY,"17:00","18:30"),
    TIME_SLOT_TUESDAY_1830_2000(DayOfWeek.TUESDAY,"18:30","20:00"),
    TIME_SLOT_TUESDAY_2000_2130(DayOfWeek.TUESDAY,"20:00","21:30"),
    TIME_SLOT_TUESDAY_2130_2300(DayOfWeek.TUESDAY,"21:30","23:00"),

    TIME_SLOT_WEDNESDAY_0630_0800(DayOfWeek.WEDNESDAY,"06:30","08:00"),
    TIME_SLOT_WEDNESDAY_0800_0930(DayOfWeek.WEDNESDAY,"08:00","09:30"),
    TIME_SLOT_WEDNESDAY_0930_1100(DayOfWeek.WEDNESDAY,"09:30","11:00"),
    TIME_SLOT_WEDNESDAY_1100_1230(DayOfWeek.WEDNESDAY,"11:00","12:00"),
    TIME_SLOT_WEDNESDAY_1230_1400(DayOfWeek.WEDNESDAY,"12:30","14:00"),
    TIME_SLOT_WEDNESDAY_1400_1530(DayOfWeek.WEDNESDAY,"14:00","15:30"),
    TIME_SLOT_WEDNESDAY_1530_1700(DayOfWeek.WEDNESDAY,"15:30","17:00"),
    TIME_SLOT_WEDNESDAY_1700_1830(DayOfWeek.WEDNESDAY,"17:00","18:30"),
    TIME_SLOT_WEDNESDAY_1830_2000(DayOfWeek.WEDNESDAY,"18:30","20:00"),
    TIME_SLOT_WEDNESDAY_2000_2130(DayOfWeek.WEDNESDAY,"20:00","21:30"),
    TIME_SLOT_WEDNESDAY_2130_2300(DayOfWeek.WEDNESDAY,"21:30","23:00"),

    TIME_SLOT_THURSDAY_0630_0800(DayOfWeek.THURSDAY,"06:30","08:00"),
    TIME_SLOT_THURSDAY_0800_0930(DayOfWeek.THURSDAY,"08:00","09:30"),
    TIME_SLOT_THURSDAY_0930_1100(DayOfWeek.THURSDAY,"09:30","11:00"),
    TIME_SLOT_THURSDAY_1100_1230(DayOfWeek.THURSDAY,"11:00","12:00"),
    TIME_SLOT_THURSDAY_1230_1400(DayOfWeek.THURSDAY,"12:30","14:00"),
    TIME_SLOT_THURSDAY_1400_1530(DayOfWeek.THURSDAY,"14:00","15:30"),
    TIME_SLOT_THURSDAY_1530_1700(DayOfWeek.THURSDAY,"15:30","17:00"),
    TIME_SLOT_THURSDAY_1700_1830(DayOfWeek.THURSDAY,"17:00","18:30"),
    TIME_SLOT_THURSDAY_1830_2000(DayOfWeek.THURSDAY,"18:30","20:00"),
    TIME_SLOT_THURSDAY_2000_2130(DayOfWeek.THURSDAY,"20:00","21:30"),
    TIME_SLOT_THURSDAY_2130_2300(DayOfWeek.THURSDAY,"21:30","23:00"),

    TIME_SLOT_FRIDAY_0630_0800(DayOfWeek.FRIDAY,"06:30","08:00"),
    TIME_SLOT_FRIDAY_0800_0930(DayOfWeek.FRIDAY,"08:00","09:30"),
    TIME_SLOT_FRIDAY_0930_1100(DayOfWeek.FRIDAY,"09:30","11:00"),
    TIME_SLOT_FRIDAY_1100_1230(DayOfWeek.FRIDAY,"11:00","12:00"),
    TIME_SLOT_FRIDAY_1230_1400(DayOfWeek.FRIDAY,"12:30","14:00"),
    TIME_SLOT_FRIDAY_1400_1530(DayOfWeek.FRIDAY,"14:00","15:30"),
    TIME_SLOT_FRIDAY_1530_1700(DayOfWeek.FRIDAY,"15:30","17:00"),
    TIME_SLOT_FRIDAY_1700_1830(DayOfWeek.FRIDAY,"17:00","18:30"),
    TIME_SLOT_FRIDAY_1830_2000(DayOfWeek.FRIDAY,"18:30","20:00"),
    TIME_SLOT_FRIDAY_2000_2130(DayOfWeek.FRIDAY,"20:00","21:30"),
    TIME_SLOT_FRIDAY_2130_2300(DayOfWeek.FRIDAY,"21:30","23:00"),

    TIME_SLOT_SATURDAY_0630_0800(DayOfWeek.SATURDAY,"06:30","08:00"),
    TIME_SLOT_SATURDAY_0800_0930(DayOfWeek.SATURDAY,"08:00","09:30"),
    TIME_SLOT_SATURDAY_0930_1100(DayOfWeek.SATURDAY,"09:30","11:00"),
    TIME_SLOT_SATURDAY_1100_1230(DayOfWeek.SATURDAY,"11:00","12:00"),
    TIME_SLOT_SATURDAY_1230_1400(DayOfWeek.SATURDAY,"12:30","14:00"),
    TIME_SLOT_SATURDAY_1400_1530(DayOfWeek.SATURDAY,"14:00","15:30"),
    TIME_SLOT_SATURDAY_1530_1700(DayOfWeek.SATURDAY,"15:30","17:00"),
    TIME_SLOT_SATURDAY_1700_1830(DayOfWeek.SATURDAY,"17:00","18:30"),
    TIME_SLOT_SATURDAY_1830_2000(DayOfWeek.SATURDAY,"18:30","20:00"),
    TIME_SLOT_SATURDAY_2000_2130(DayOfWeek.SATURDAY,"20:00","21:30"),
    TIME_SLOT_SATURDAY_2130_2300(DayOfWeek.SATURDAY,"21:30","23:00"),

    TIME_SLOT_SUNDAY_0630_0800(DayOfWeek.SUNDAY,"06:30","08:00"),
    TIME_SLOT_SUNDAY_0800_0930(DayOfWeek.SUNDAY,"08:00","09:30"),
    TIME_SLOT_SUNDAY_0930_1100(DayOfWeek.SUNDAY,"09:30","11:00"),
    TIME_SLOT_SUNDAY_1100_1230(DayOfWeek.SUNDAY,"11:00","12:00"),
    TIME_SLOT_SUNDAY_1230_1400(DayOfWeek.SUNDAY,"12:30","14:00"),
    TIME_SLOT_SUNDAY_1400_1530(DayOfWeek.SUNDAY,"14:00","15:30"),
    TIME_SLOT_SUNDAY_1530_1700(DayOfWeek.SUNDAY,"15:30","17:00"),
    TIME_SLOT_SUNDAY_1700_1830(DayOfWeek.SUNDAY,"17:00","18:30"),
    TIME_SLOT_SUNDAY_1830_2000(DayOfWeek.SUNDAY,"18:30","20:00"),
    TIME_SLOT_SUNDAY_2000_2130(DayOfWeek.SUNDAY,"20:00","21:30"),
    TIME_SLOT_SUNDAY_2130_2300(DayOfWeek.SUNDAY,"21:30","23:00");


    private final String from;
    private final String to;
    private final DayOfWeek dayOfWeek;

    private TimeSlot(DayOfWeek dayOfWeek,String from,String to) {
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


}
