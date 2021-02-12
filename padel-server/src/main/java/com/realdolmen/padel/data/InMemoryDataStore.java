package com.realdolmen.padel.data;

import com.realdolmen.padel.model.*;
import com.realdolmen.padel.model.builder.MemberBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InMemoryDataStore {
    public static final String DUMMY_GROUP = "DUMMY";
    public static final String P500_MEN = "P500H";
    public static final String P300_MEN = "P300H";
    public static final String P200_MEN = "P200H";
    public static final String P100_MEN = "P100H";
    public static final String P50_WOMEN = "P100V";
    public static final String P100_WOMEN = "P100V";
    public static final String P200_WOMEN = "P200V";

    public static final String WOMEN = "W";
    public static final String MEN = "H";
    public static final String MIXED = "M";


    private static List<Reservation> reservations=new ArrayList<Reservation>();

    private static List<Group> padelGroups=new ArrayList<Group>();

    static{
        padelGroups.add(new Group(1L,P500_MEN,Arrays.asList("H")));
        padelGroups.add(new Group(2L,P300_MEN,Arrays.asList("H")));
        padelGroups.add(new Group(3L,P200_MEN,Arrays.asList("H")));
        padelGroups.add(new Group(4L,P100_MEN,Arrays.asList("H")));
        padelGroups.add(new Group(5L,P50_WOMEN,Arrays.asList("V")));
        padelGroups.add(new Group(6L,P100_WOMEN,Arrays.asList("V")));
        padelGroups.add(new Group(7L,P200_WOMEN,Arrays.asList("V")));
        padelGroups.add(new Group(8L,DUMMY_GROUP,Arrays.asList("V")));
    }


    private static List<Member> padelMembers=new ArrayList<Member>();
    static{
        //P500H
        padelMembers.add(new MemberBuilder().setId(1L).setName("D'hose").setFirstName("Kris").setActive("Y").setLevel(getPadelGroup(P500_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(2L).setName("Goossens").setFirstName("Werner").setActive("Y").setLevel(getPadelGroup(P500_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(3L).setName("Stalpaert").setFirstName("Bart").setActive("Y").setLevel(getPadelGroup(P500_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(4L).setName("Vandevelde").setFirstName("Tom").setActive("Y").setLevel(getPadelGroup(P500_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(5L).setName("Vanhee").setFirstName("Kris").setActive("Y").setLevel(getPadelGroup(P500_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(6L).setName("Verplanken").setFirstName("Christophe").setActive("Y").setLevel(getPadelGroup(P500_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        //P300H,first week of month part of P500H


        //P300H,first week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(7L).setName("Van Heddeghem").setFirstName("Frederik").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(), getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(8L).setName("Dirk").setFirstName("Demil").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(9L).setName("Van Wymeersch").setFirstName("Tim").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());

        //P300H,second week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(10L).setName("Uyttenhove").setFirstName("Dries").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.SECOND_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(11L).setName("De Smedt").setFirstName("Dominik").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.SECOND_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(12L).setName("Leroy").setFirstName("Pedro").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.SECOND_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());

        //P300H,third week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(13L).setName("Torrekens").setFirstName("Bruno").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.THIRD_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(14L).setName("Van Huffel").setFirstName("Diego").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.THIRD_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(15L).setName("Verstichelen").setFirstName("Davy").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.THIRD_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());

        //P300H,fourth week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(16L).setName("De Smet Van Damme").setFirstName("Jan").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FOURTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(17L).setName("D'Hoker").setFirstName("Pieter").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FOURTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(18L).setName("Leroy").setFirstName("Wendy").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FOURTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(19L).setName("Paternoster").setFirstName("Stefaan").setActive("Y").setLevel(getPadelGroup(P300_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FOURTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P500_MEN)))).build());


        //P200H,first week of month part of P300H
        padelMembers.add(new MemberBuilder().setId(20L).setName("Baeyens").setFirstName("Brecht").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(), getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(), getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(21L).setName("Capelleman").setFirstName("Philip").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(22L).setName("Coesens").setFirstName("Joris").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(23L).setName("Collage").setFirstName("Kristof").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(24L).setName("Cortier").setFirstName("Kathy").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(25L).setName("De Backer").setFirstName("Bart").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(26L).setName("De Brakeleer").setFirstName("Kristof").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(27L).setName("Janssens").setFirstName("Johan").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(28L).setName("Paternoster").setFirstName("Kris").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(29L).setName("Peereman").setFirstName("Frederik").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(30L).setName("Reyns").setFirstName("Liesbet").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(31L).setName("De Clercq").setFirstName("Stijn").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(32L).setName("De Cock").setFirstName("Jurgen").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(33L).setName("Delestrée").setFirstName("Jasper").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(34L).setName("De Meester").setFirstName("Jan").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(35L).setName("Diependaele").setFirstName("Ilse").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(36L).setName("Eeckhout").setFirstName("Andy").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(37L).setName("Van Haesevelde").setFirstName("Ellert").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(38L).setName("Vanhee").setFirstName("Dieter").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(39L).setName("Verplanken").setFirstName("Marco").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(40L).setName("Verstuyft").setFirstName("Joeri").setActive("Y").setLevel(getPadelGroup(P200_MEN)).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P200_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY.getWeekNumbers(),getPadelGroup(P300_MEN)))).build());


    }

    private static List<Court> courtList=new ArrayList<Court>();

    static{
        courtList.add(new Court(1L,"1"));
        courtList.add(new Court(2L,"2"));
    }

    public static Group getPadelGroup(String groupName){
        Group group=null;
        Optional<Group> groupOptional = padelGroups.stream().filter(Group.Predicates.withGroupName(groupName)).findFirst();
        if (groupOptional.isPresent()){
            group = groupOptional.get();
        }
        return group;
    }

    public static List<Group> getGroups(){
        return padelGroups;
    }

    public static List<Reservation> getReservations(){
        return reservations;
    }

    public static List<Member> getPadelMembers(){
        return padelMembers;
    }

    public static List<Court> getCourtList(){
        return courtList;
    }


}
