package com.realdolmen.padel.model;

import com.realdolmen.padel.entity.CourtTimeSlotEntity;
import com.realdolmen.padel.entity.GroupEntity;
import com.realdolmen.padel.entity.VtvLevelEntity;
import org.springframework.util.CollectionUtils;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourtTimeSlot {
    private long id;
    private TimeSlot timeSlot;
    private Court court;

    public CourtTimeSlot(long id, TimeSlot timeSlot, Court court) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.court = court;
    }

    public CourtTimeSlot() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourtTimeSlot that = (CourtTimeSlot) o;
        return id == that.id && timeSlot == that.timeSlot && Objects.equals(court, that.court);
    }

    @Override
    public String
    toString() {
        return "CourtTimeSlot{" +
                "id=" + id +
                ", timeSlot=" + timeSlot +
                ", court=" + court +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeSlot, court);
    }


    public static class Predicates {

        public static final Predicate<CourtTimeSlot> withId(final Long id) {
            return new Predicate<CourtTimeSlot>() {
                @Override
                public boolean test(CourtTimeSlot courtTimeSlot) {
                    return courtTimeSlot.getId() == id;
                }
            };
        }

        public static final Predicate<CourtTimeSlot> withTimeSlot(final TimeSlot timeSlot) {
            return new Predicate<CourtTimeSlot>() {
                @Override
                public boolean test(CourtTimeSlot courtTimeSlot) {
                    return courtTimeSlot.getTimeSlot().equals(timeSlot);
                }
            };
        }

        public static final Predicate<CourtTimeSlot> withTimeSlotId(final Long timeSlotId) {
            return new Predicate<CourtTimeSlot>() {
                @Override
                public boolean test(CourtTimeSlot courtTimeSlot) {
                    boolean hasSameSlotId =  courtTimeSlot.getTimeSlot().getId().equals(timeSlotId);
                    return hasSameSlotId;
                }
            };
        }

        public static final Predicate<CourtTimeSlot> withGroupName(final String courtName) {
            return new Predicate<CourtTimeSlot>() {
                @Override
                public boolean test(CourtTimeSlot courtTimeSlot) {
                    return courtTimeSlot.getCourt().getName().equalsIgnoreCase(courtName);
                }
            };
        }

        public static final Predicate<CourtTimeSlot> withCourtId(final Long id) {
            return new Predicate<CourtTimeSlot>() {
                @Override
                public boolean test(CourtTimeSlot courtTimeSlot) {
                    boolean hasSameCourtId = courtTimeSlot.getCourt().getId() == id;
                    return hasSameCourtId;
                }
            };
        }
    }




    public static class Functions {

        public static Function<CourtTimeSlotEntity, CourtTimeSlot> FROM_COURT_TIMESLOT_ENTITY = new Function<CourtTimeSlotEntity, CourtTimeSlot>() {
            @Override
            public CourtTimeSlot apply(CourtTimeSlotEntity courtTimeSlotEntity) {
                CourtTimeSlot courtTimeSlot = new CourtTimeSlot();
                courtTimeSlot.setId(courtTimeSlotEntity.getId());
                if (courtTimeSlotEntity.getCourtEntity() != null){
                    Court court = Court.Functions.FROM_COURT_ENTITY.apply(courtTimeSlotEntity.getCourtEntity());
                    courtTimeSlot.setCourt(court);
                }
                if (courtTimeSlotEntity.getTimeSlotEntity() != null){
                    TimeSlot timeSlot = TimeSlot.Functions.FROM_TIMESLOT_ENTITY.apply(courtTimeSlotEntity.getTimeSlotEntity());
                    courtTimeSlot.setTimeSlot(timeSlot);
                }
                return courtTimeSlot;

            }
        };



    }









}
