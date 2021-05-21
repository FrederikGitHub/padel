package com.realdolmen.padel.model;

import com.realdolmen.padel.entity.MemberEntity;
import com.realdolmen.padel.entity.ReservationEntity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Reservation {
    private long id;
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer week;
    private CourtTimeSlot courtTimeSlot;
    private List<Member> reservationMembers;
    private List<Member> reserveMembers;
    private Group group;

    public long getId() {
        return id;
    }

    public Reservation setId(long id) {
        this.id = id;
        return this;
    }

    public Integer getDay() {
        return day;
    }

    public Reservation setDay(Integer day) {
        this.day = day;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public Reservation setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Reservation setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getWeek() {
        return week;
    }

    public Reservation setWeek(Integer week) {
        this.week = week;
        return this;
    }

    public CourtTimeSlot getCourtTimeSlot() {
        return courtTimeSlot;
    }

    public Reservation setCourtTimeSlot(CourtTimeSlot courtTimeSlot) {
        this.courtTimeSlot = courtTimeSlot;
        return this;
    }

    public List<Member> getReservationMembers() {
        return reservationMembers;
    }

    public Reservation setReservationMembers(List<Member> reservationMembers) {
        this.reservationMembers = reservationMembers;
        return this;
    }

    public Reservation setReserveMembers(List<Member> reserveMembers) {
        this.reserveMembers = reserveMembers;
        return this;
    }

    public Reservation setGroup(Group group) {
        this.group = group;
        return this;
    }

    public List<Member> getReserveMembers() {
        return reserveMembers;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", week=" + week +
                ", timeSlot=" + courtTimeSlot +
                ", reservationMembers=" + reservationMembers +
                ", reserveMembers=" + reserveMembers +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(day, that.day) && Objects.equals(month, that.month) && Objects.equals(year, that.year) && Objects.equals(week, that.week) && Objects.equals(courtTimeSlot, that.courtTimeSlot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, month, year, week, courtTimeSlot, reservationMembers);
    }

    public static class Functions {

        public static Function<Reservation, Stream<Member>> TO_MEMBERS = new Function<Reservation, Stream<Member>>() {
            @Override
            public Stream<Member> apply(Reservation reservation) {
                return reservation.getReservationMembers().stream();
            }
        };

        public static Function<Reservation, Stream<Member>> TO_RESERVE_MEMBERS = new Function<Reservation, Stream<Member>>() {
            @Override
            public Stream<Member> apply(Reservation reservation) {
                return reservation.getReserveMembers().stream();
            }
        };

        public static Function<Reservation, CourtTimeSlot> TO_COURT_TIMESLOT = new Function<Reservation, CourtTimeSlot>() {
            @Override
            public CourtTimeSlot apply(Reservation reservation) {
                return reservation.getCourtTimeSlot();
            }
        };

        public static Function<Reservation, Court> TO_COURT = new Function<Reservation, Court>() {
            @Override
            public Court apply(Reservation reservation) {
                return reservation.getCourtTimeSlot().getCourt();
            }
        };

        public static Function<Reservation, LocalDate> TO_PLAY_DATE = new Function<Reservation, LocalDate>() {
            @Override
            public LocalDate apply(Reservation reservation) {
                return LocalDate.of(reservation.getYear(), reservation.getMonth(), reservation.getDay());
            }
        };

        public static Function<Reservation, Week> TO_WEEK = new Function<Reservation, Week>() {
            @Override
            public Week apply(Reservation reservation) {
                LocalDate reservationDate = LocalDate.of(reservation.getYear(), reservation.getMonth(), reservation.getDay());
                WeekFields weekFields
                        = WeekFields.of(DayOfWeek.MONDAY, 1);
                TemporalField weekOfYear
                        = weekFields.weekOfYear();
                TemporalField weekOfMonth
                        = weekFields.weekOfMonth();
                LocalDate monday = reservationDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
                LocalDate sunday = reservationDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
                Week week = new Week(sunday.get(weekOfYear), sunday.get(weekOfMonth), monday, sunday, monday.getYear());
                return week;
            }
        };

        public static Function<ReservationEntity, Reservation> FROM_RESERVATION_ENTITY = new Function<ReservationEntity, Reservation>() {
            @Override
            public Reservation apply(ReservationEntity memberEntity) {
                Reservation reservation = new Reservation();

                return reservation;
            }
        };

    }




    public static class Predicates {

        public static final Predicate<Reservation> withCourtTimeSlot(final CourtTimeSlot courtTimeSlot) {
            return new Predicate<Reservation>() {
                @Override
                public boolean test(Reservation reservation) {
                    return reservation.getCourtTimeSlot().getCourt().getName().equalsIgnoreCase(courtTimeSlot.getCourt().getName()) && reservation.getCourtTimeSlot().getTimeSlot().getDayOfWeek().equals(courtTimeSlot.getTimeSlot().getDayOfWeek()) && reservation.getCourtTimeSlot().getTimeSlot().getFrom().equals(courtTimeSlot.getTimeSlot().getFrom()) && reservation.getCourtTimeSlot().getTimeSlot().getTo().equals(courtTimeSlot.getTimeSlot().getTo());
                }
            };
        }

        public static final Predicate<Reservation> withDate(final LocalDate localDate) {
            return new Predicate<Reservation>() {
                @Override
                public boolean test(Reservation reservation) {
                    return reservation.getYear().equals(localDate.getYear()) && reservation.getMonth().equals(localDate.getMonthValue()) && reservation.getDay().equals(localDate.getDayOfMonth());
                }
            };
        }

        public static final Predicate<Reservation> isBeforeDate(final LocalDate endDate) {
            return new Predicate<Reservation>() {
                @Override
                public boolean test(Reservation reservation) {
                    LocalDate reservationDate = LocalDate.of(reservation.getYear(),reservation.getMonth(),reservation.getDay());
                    return reservationDate.isBefore(endDate);
                }
            };
        }

        public static final Predicate<Reservation> isAfterDate(final LocalDate startDate) {
            return new Predicate<Reservation>() {
                @Override
                public boolean test(Reservation reservation) {
                    LocalDate reservationDate = LocalDate.of(reservation.getYear(),reservation.getMonth(),reservation.getDay());
                    return reservationDate.isAfter(startDate);
                }
            };
        }

        public static final Predicate<Reservation> hasMember(final Member member) {
            return new Predicate<Reservation>() {
                @Override
                public boolean test(Reservation reservation) {
                    List<Member> reservationMembers = reservation.getReservationMembers();
                    return reservationMembers.contains(member);
                }
            };
        }

        public static final Predicate<Reservation> withGroup(final Group group) {
            return new Predicate<Reservation>() {
                @Override
                public boolean test(Reservation reservation) {
                    return reservation.getGroup().equals(group);
                }
            };
        }



    }
}

