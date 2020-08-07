package com.realdolmen.padel.model.builder;

import com.realdolmen.padel.model.Court;
import com.realdolmen.padel.model.TimeSlot;
import com.realdolmen.padel.model.WeekDay;

public class TimeSlotBuilder {
    private long id;
    private WeekDay weekday;
    private String from;
    private String to;
    private Court court;

    public TimeSlotBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public TimeSlotBuilder setWeekday(WeekDay weekday) {
        this.weekday = weekday;
        return this;
    }

    public TimeSlotBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public TimeSlotBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public TimeSlotBuilder setCourt(Court court) {
        this.court = court;
        return this;
    }

    public TimeSlot build(){
        return new TimeSlot(this.id,this.weekday,this.from,this.to,this.court);
    }
}
