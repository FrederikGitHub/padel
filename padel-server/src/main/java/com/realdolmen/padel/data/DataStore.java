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

    static final String BUBBEL_ONE_MEN = "MANNEN-A";
    static final String BUBBEL_TWO_MEN = "MANNEN-B";
    static final String BUBBEL_THREE_MEN = "MANNEN-C";
    static final String BUBBEL_FOUR_MEN = "MANNEN-D";
    static final String BUBBEL_FIVE_MEN = "MANNEN-E";
    static final String BUBBEL_SIX_MEN = "MANNEN-F";
    static final String BUBBEL_SEVEN_MEN = "MANNEN-G";
    static final String BUBBEL_EIGHT_MEN = "MANNEN-H";

    static final String BUBBEL_ONE_WOMEN = "VROUWEN-A";
    static final String BUBBEL_TWO_WOMEN = "VROUWEN-B";
    static final String BUBBEL_THREE_WOMEN = "VROUWEN-C";
    static final String BUBBEL_FOUR_WOMEN = "VROUWEN-D";

    static final VtvLevel P50_LEVEL = new VtvLevel(1L,"P50");
    static final VtvLevel P100_LEVEL = new VtvLevel(2L,"P1000");
    static final VtvLevel P200_LEVEL = new VtvLevel(3L,"P200");
    static final VtvLevel P300_LEVEL = new VtvLevel(4L,"P300");
    static final VtvLevel P500_LEVEL = new VtvLevel(5L,"P500");
    static final VtvLevel P750_LEVEL = new VtvLevel(6L,"P750");
    static final VtvLevel P1000_LEVEL = new VtvLevel(7L,"P1000");

    static final String WOMEN = "V";
    static final String MEN = "M";

    List<Group> getGroups();

    List<Reservation> getReservations();

    List<Member> getPadelMembers();

    List<Court> getCourtList();

    List<VtvLevel> getVtvLevels();

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
