package com.realdolmen.padel.model;

public enum ReservationType {
    FIXED  ("FIXED"),
    POULE("POULE");

    private final String name;

    private ReservationType(String name) {
        this.name = name;
    }
}
