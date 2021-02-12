package com.realdolmen.padel.model.builder;

import com.realdolmen.padel.model.Court;
import com.realdolmen.padel.model.CourtTimeSlot;
import com.realdolmen.padel.model.TimeSlot;
import com.realdolmen.padel.model.WeekDay;

public class CourtTimeSlotBuilder {
    private long id;
    private TimeSlot timeSlot;
    private Court court;

    public CourtTimeSlotBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public CourtTimeSlotBuilder setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
        return this;
    }


    public CourtTimeSlotBuilder setCourt(Court court) {
        this.court = court;
        return this;
    }

    public CourtTimeSlot build(){
        return new CourtTimeSlot(this.id,this.timeSlot,this.court);
    }
}
