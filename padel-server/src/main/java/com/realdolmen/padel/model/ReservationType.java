package com.realdolmen.padel.model;

import com.realdolmen.padel.entity.ReservationTypeEntity;

import java.util.function.Function;

public enum ReservationType {
    FIXED(3L, "MANUAL"),
    AUTO(4L, "AUTO");

    private final String name;
    private final Long id;

    private ReservationType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReservationType{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public static ReservationType lookupReservationType(String name) {
        for (ReservationType reservationType : ReservationType.values()) {
            if (reservationType.getName().equals(name)) {
                return reservationType;
            }
        }
        return null;
    }

    public static class Functions {

        public static Function<ReservationTypeEntity, ReservationType> FROM_RESERVATION_TYPE_ENTITY = new Function<ReservationTypeEntity, ReservationType>() {
            @Override
            public ReservationType apply(ReservationTypeEntity reservationTypeEntity) {
                ReservationType reservationtype = ReservationType.lookupReservationType(reservationTypeEntity.getName());

                return reservationtype;
            }
        };

    }


}



