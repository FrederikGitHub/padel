package com.realdolmen.padel.data;

import com.realdolmen.padel.model.*;

import java.util.List;


public interface DataStore {

    static final String DUMMY_GROUP = "DUMMY";
    static final String P500_MEN = "P500M";
    static final String P300_MEN = "P300M";
    static final String P200_MEN = "P200M";
    static final String P100_MEN = "P100M";
    static final String P50_WOMEN = "P50W";
    static final String P100_WOMEN = "P100W";
    static final String P200_WOMEN = "P200W";

    static final String BUBBEL_ONE = "BUBBEL-ONE";
    static final String BUBBEL_TWO = "BUBBEL-TWO";
    static final String BUBBEL_THREE = "BUBBEL-THREE";
    static final String BUBBEL_FOUR = "BUBBEL-FOUR";
    static final String BUBBEL_FIVE = "BUBBEL-FIVE";
    static final String BUBBEL_SIX = "BUBBEL-SIX";
    static final String BUBBEL_SEVEN = "BUBBEL-SEVEN";
    static final String BUBBEL_EIGHT = "BUBBEL-EIGHT";
    static final String BUBBEL_NINE = "BUBBEL-NINE";
    static final String BUBBEL_TEN = "BUBBEL-TEN";

    static final String P50_LEVEL = "P50";
    static final String P100_LEVEL = "P100";
    static final String P200_LEVEL = "P200";
    static final String P300_LEVEL = "P300";
    static final String P500_LEVEL = "P500";
    static final String P750_LEVEL = "P750";
    static final String P1000_LEVEL = "P1000";

    static final String WOMEN = "V";
    static final String MEN = "M";

    List<Group> getGroups();

    List<Reservation> getReservations();

    List<Member> getPadelMembers();

    List<Court> getCourtList();

    List<String> getVtvLevels();

    List<Availability> getAvailabilities();

    List<TimeSlot> getTimeSlots();

    List<CourtTimeSlot> getCourtTimeSlots();

    void create(Member member);

    void delete(Member member);

    void update(Member member);

    void create(Group group);

    void delete(Group group);

    void update(Group group);

    void create(Court court);

    void delete(Court court);

    void update(Court court);

    void create(Reservation reservation);

    void delete(Reservation reservation);

    void update(Reservation reservation);

    void deleteAllReservations();


    void create(TimeSlot timeSlot);

    void delete(TimeSlot timeSlot);

    void update(TimeSlot timeSlot);

}
