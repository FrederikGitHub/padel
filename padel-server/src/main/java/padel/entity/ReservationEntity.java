package padel.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RESERVATION", schema = "padel")
public class ReservationEntity {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "RESERVATION_DAY")
    private Integer day;

    @Basic
    @Column(name = "RESERVATION_MONTH")
    private Integer month;

    @Basic
    @Column(name = "RESERVATION_YEAR")
    private Integer year;

    @Basic
    @Column(name = "RESERVATION_WEEK")
    private Integer week;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_TIMESLOT_ID")
    private TimeSlotEntity timeSlot;

    @OneToMany(mappedBy = "reservation")
    private Set<ReservationMemberEntity> reservationMembers;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_RESERVATION_TYPE_ID")
    private ReservationTypeEntity reservationType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public TimeSlotEntity getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlotEntity timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Set<ReservationMemberEntity> getReservationMembers() {
        return reservationMembers;
    }

    public void setReservationMembers(Set<ReservationMemberEntity> reservationMembers) {
        this.reservationMembers = reservationMembers;
    }

    public ReservationTypeEntity getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationTypeEntity reservationType) {
        this.reservationType = reservationType;
    }
}
