package padel.entity;

import javax.persistence.*;

@Entity
@Table(name = "TIMESLOT", schema = "padel")
public class TimeSlotEntity {

    @Id
    @Column(name = "TIMESLOT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "TIMESLOT_WEEKDAY_ID")
    private WeekDayEntity weekday;

    @Basic
    @Column(name = "TIMESLOT_FROM")
    private String from;

    @Basic
    @Column(name = "TIMESLOT_TO")
    private String to;

    @ManyToOne
    @JoinColumn(name = "TIMESLOT_COURT_ID")
    private CourtEntity court;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WeekDayEntity getWeekday() {
        return weekday;
    }

    public void setWeekday(WeekDayEntity weekday) {
        this.weekday = weekday;
    }

    public CourtEntity getCourt() {
        return court;
    }

    public void setCourt(CourtEntity court) {
        this.court = court;
    }
}
