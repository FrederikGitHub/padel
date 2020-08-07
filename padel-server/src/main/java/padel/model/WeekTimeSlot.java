package padel.model;

import java.time.LocalDate;

public class WeekTimeSlot {
    private LocalDate day;
    private TimeSlot timeslot;
    private Integer weekNr;

    public LocalDate getDay() {
        return day;
    }

    public WeekTimeSlot setDay(LocalDate day) {
        this.day = day;
        return this;
    }

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public WeekTimeSlot setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
        return this;
    }

    public Integer getWeekNr() {
        return weekNr;
    }

    public WeekTimeSlot setWeekNr(Integer weekNr) {
        this.weekNr = weekNr;
        return this;
    }

    @Override
    public String toString() {
        return "WeekTimeSlot{" +
                "day=" + day +
                ", timeslot=" + timeslot +
                ", weekNr=" + weekNr +
                '}';
    }
}
