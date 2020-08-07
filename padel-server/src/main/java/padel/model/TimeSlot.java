package padel.model;

import java.util.Objects;

public class TimeSlot {
    private long id;
    private WeekDay weekday;
    private String from;
    private String to;
    private Court court;

    public TimeSlot(long id, WeekDay weekday, String from, String to, Court court) {
        this.id = id;
        this.weekday = weekday;
        this.from = from;
        this.to = to;
        this.court = court;
    }

    public long getId() {
        return id;
    }

    public TimeSlot setId(long id) {
        this.id = id;
        return this;
    }

    public WeekDay getWeekday() {
        return weekday;
    }

    public TimeSlot setWeekday(WeekDay weekday) {
        this.weekday = weekday;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public TimeSlot setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public TimeSlot setTo(String to) {
        this.to = to;
        return this;
    }

    public Court getCourt() {
        return court;
    }

    public TimeSlot setCourt(Court court) {
        this.court = court;
        return this;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", weekday=" + weekday +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", court=" + court +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return id == timeSlot.id &&
                Objects.equals(weekday, timeSlot.weekday) &&
                Objects.equals(from, timeSlot.from) &&
                Objects.equals(to, timeSlot.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weekday, from, to);
    }


}
