package com.realdolmen.padel.data;

import com.realdolmen.padel.model.*;
import com.realdolmen.padel.model.builder.MemberBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.padel.model.Availability.*;

@Component
@Primary
public class InMemoryDataStore implements DataStore{




    private static List<Reservation> reservations=new ArrayList<Reservation>();

    private static List<Group> clubGroups =new ArrayList<Group>();

    private static List<String> vtvLevels=new ArrayList<String>();

    private static List<Availability> availabilities =new ArrayList<Availability>();

    private static List<TimeSlot> timeSlots =new ArrayList<TimeSlot>();


    private static List<String> genders=new ArrayList<String>();



    static{
        vtvLevels.add(P50_LEVEL);
        vtvLevels.add(P100_LEVEL);
        vtvLevels.add(P200_LEVEL);
        vtvLevels.add(P300_LEVEL);
        vtvLevels.add(P500_LEVEL);
        vtvLevels.add(P750_LEVEL);
        vtvLevels.add(P1000_LEVEL);
    }

    static{
        genders.add(WOMEN);
        vtvLevels.add(MEN);
    }


    static{
        clubGroups.add(new Group(1L,P50_WOMEN,P50_LEVEL));
        clubGroups.add(new Group(2L,P100_WOMEN,P100_LEVEL));
        clubGroups.add(new Group(3L,P200_WOMEN,P200_LEVEL));
        clubGroups.add(new Group(4L,P100_MEN,P100_LEVEL));
        clubGroups.add(new Group(5L,P200_MEN,P200_LEVEL));
        clubGroups.add(new Group(6L,P300_MEN,P300_LEVEL));
        clubGroups.add(new Group(7L,P500_MEN,P500_LEVEL));
        clubGroups.add(new Group(8L,DUMMY_GROUP,P500_LEVEL));
    }
    static{
        availabilities.add(FIRST_WEEK_AVAILABILITY);
        availabilities.add(SECOND_WEEK_AVAILABILITY);
        availabilities.add(THIRD_WEEK_AVAILABILITY);
        availabilities.add(FOURTH_WEEK_AVAILABILITY);
        availabilities.add(FIRST_SECOND_WEEK_AVAILABILITY);
        availabilities.add(FIRST_THIRD_WEEK_AVAILABILITY);
        availabilities.add(FIRST_FOURTH_WEEK_AVAILABILITY);
        availabilities.add(SECOND_FOURTH_WEEK_AVAILABILITY);
        availabilities.add(SECOND_THIRD_WEEK_AVAILABILITY);
        availabilities.add(THIRD_FOURTH_WEEK_AVAILABILITY);
        availabilities.add(THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(SECOND_THIRD_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(FIRST_THIRD_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(FIRST_FOURTH_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(FIRST_SECOND_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY);
        availabilities.add(FULL_TIME_AVAILABILITY);
    }

    static{
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_0800_0930);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_0930_1100);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_1100_1230);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_1230_1400);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_1400_1530);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_1530_1700);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_1700_1830);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_1830_2000);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_2000_2130);
        timeSlots.add(TimeSlot.TIME_SLOT_MONDAY_2130_2300);

        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_0800_0930);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_0930_1100);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_1100_1230);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_1230_1400);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_1400_1530);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_1530_1700);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_1700_1830);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_1830_2000);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_2000_2130);
        timeSlots.add(TimeSlot.TIME_SLOT_TUESDAY_2130_2300);

        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_0800_0930);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_0930_1100);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_1100_1230);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_1230_1400);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_1400_1530);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_1530_1700);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_1700_1830);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_1830_2000);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_2000_2130);
        timeSlots.add(TimeSlot.TIME_SLOT_WEDNESDAY_2130_2300);

        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_0800_0930);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_0930_1100);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_1100_1230);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_1230_1400);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_1400_1530);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_1530_1700);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_1700_1830);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_1830_2000);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_2000_2130);
        timeSlots.add(TimeSlot.TIME_SLOT_THURSDAY_2130_2300);

        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_0800_0930);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_0930_1100);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_1100_1230);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_1230_1400);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_1400_1530);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_1530_1700);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_1700_1830);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_1830_2000);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_2000_2130);
        timeSlots.add(TimeSlot.TIME_SLOT_FRIDAY_2130_2300);

        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_0800_0930);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_0930_1100);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_1100_1230);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_1230_1400);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_1400_1530);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_1530_1700);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_1700_1830);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_1830_2000);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_2000_2130);
        timeSlots.add(TimeSlot.TIME_SLOT_SATURDAY_2130_2300);

        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_0630_0800);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_0800_0930);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_0930_1100);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_1100_1230);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_1230_1400);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_1400_1530);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_1530_1700);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_1700_1830);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_1830_2000);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_2000_2130);
        timeSlots.add(TimeSlot.TIME_SLOT_SUNDAY_2130_2300);
    }


    private static List<Member> padelMembers=new ArrayList<Member>();
    static{
        //P500H
        padelMembers.add(new MemberBuilder().setId(1L).setName("D'hose").setFirstName("Kris").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(2L).setName("Goossens").setFirstName("Werner").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(3L).setName("Stalpaert").setFirstName("Bart").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(4L).setName("Vandevelde").setFirstName("Tom").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(5L).setName("Vanhee").setFirstName("Kris").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(6L).setName("Verplanken").setFirstName("Christophe").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        //P300H,first week of month part of P500H


        //P300H,first week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(7L).setName("Van Heddeghem").setFirstName("Frederik").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY, getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(8L).setName("Dirk").setFirstName("Demil").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(9L).setName("Van Wymeersch").setFirstName("Tim").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());

        //P300H,second week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(10L).setName("Uyttenhove").setFirstName("Dries").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.SECOND_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(11L).setName("De Smedt").setFirstName("Dominik").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.SECOND_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(12L).setName("Leroy").setFirstName("Pedro").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.SECOND_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());

        //P300H,third week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(13L).setName("Torrekens").setFirstName("Bruno").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.THIRD_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(14L).setName("Van Huffel").setFirstName("Diego").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.THIRD_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(15L).setName("Verstichelen").setFirstName("Davy").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.THIRD_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());

        //P300H,fourth week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(16L).setName("De Smet Van Damme").setFirstName("Jan").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FOURTH_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(17L).setName("D'Hoker").setFirstName("Pieter").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FOURTH_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(18L).setName("Leroy").setFirstName("Wendy").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FOURTH_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(19L).setName("Paternoster").setFirstName("Stefaan").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_SECOND_THIRD_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FOURTH_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());


        //P200H,first week of month part of P300H
        padelMembers.add(new MemberBuilder().setId(20L).setName("Baeyens").setFirstName("Brecht").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY, getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY, getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(21L).setName("Capelleman").setFirstName("Philip").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(22L).setName("Coesens").setFirstName("Joris").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(23L).setName("Collage").setFirstName("Kristof").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(24L).setName("Cortier").setFirstName("Kathy").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(25L).setName("De Backer").setFirstName("Bart").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(26L).setName("De Brakeleer").setFirstName("Kristof").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(27L).setName("Janssens").setFirstName("Johan").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(28L).setName("Paternoster").setFirstName("Kris").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(29L).setName("Peereman").setFirstName("Frederik").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(30L).setName("Reyns").setFirstName("Liesbet").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(31L).setName("De Clercq").setFirstName("Stijn").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(32L).setName("De Cock").setFirstName("Jurgen").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(33L).setName("Delestrée").setFirstName("Jasper").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(34L).setName("De Meester").setFirstName("Jan").setActive("Y").setLevel(P200_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(35L).setName("Diependaele").setFirstName("Ilse").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(36L).setName("Eeckhout").setFirstName("Andy").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(37L).setName("Van Haesevelde").setFirstName("Ellert").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(38L).setName("Vanhee").setFirstName("Dieter").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(39L).setName("Verplanken").setFirstName("Marco").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());
        padelMembers.add(new MemberBuilder().setId(40L).setName("Verstuyft").setFirstName("Joeri").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P200_MEN)),new GroupAvailability(FIRST_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)))).build());


    }

    private static List<Court> courtList=new ArrayList<Court>();

    static{
        courtList.add(new Court(1L,"1"));
        courtList.add(new Court(2L,"2"));
    }

    private static Group getPadelGroup(String groupName){
        Group group=null;
        Optional<Group> groupOptional = clubGroups.stream().filter(Group.Predicates.withGroupName(groupName)).findFirst();
        if (groupOptional.isPresent()){
            group = groupOptional.get();
        }
        return group;
    }

    public List<Group> getGroups(){
        return clubGroups;
    }

    public List<Reservation> getReservations(){
        return reservations;
    }

    public List<Member> getPadelMembers(){
        return padelMembers;
    }

    public List<Court> getCourtList(){
        return courtList;
    }

    public List<String> getVtvLevels(){
        return vtvLevels;
    }

    public List<Availability> getAvailabilities(){
        return availabilities;
    }

    @Override
    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    @Override
    public void create(Member member) {
        long nextMemberId = getPadelMembers().size() + 1;
        member.setId(nextMemberId);
        getPadelMembers().add(member);
    }

    @Override
    public void delete(Member member) {
        getPadelMembers().remove(member);
    }

    @Override
    public void update(Member memberToUpdate) {
        int index = 0;
        for (Member member:getPadelMembers()){
            if (member.equals(memberToUpdate)){
                break;
            }
            index++;
        }
        getPadelMembers().set(index,memberToUpdate);
    }

    @Override
    public void create(Court court) {
        long nextCourtId = getCourtList().size() + 1;
        court.setId(nextCourtId);
        getCourtList().add(court);
    }

    @Override
    public void delete(Court court) {
        getCourtList().remove(court);
    }

    @Override
    public void update(Court courtToBeUpdated) {
        int index = 0;
        for (Court court:getCourtList()){
            if (court.equals(courtToBeUpdated)){
                break;
            }
            index++;
        }
        getCourtList().set(index,courtToBeUpdated);
    }

    @Override
    public void create(Reservation reservation) {
        long nextReservationId = getReservations().size() + 1;
        reservation.setId(nextReservationId);
        getReservations().add(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        getReservations().remove(reservation);
    }

    @Override
    public void update(Reservation reservationToBeUpdated) {
        int index = 0;
        for (Reservation reservation:getReservations()){
            if (reservation.equals(reservationToBeUpdated)){
                break;
            }
            index++;
        }
        getReservations().set(index,reservationToBeUpdated);
    }

    @Override
    public void deleteAllReservations() {
        getReservations().clear();
    }

    @Override
    public void create(TimeSlot timeSlot) {

    }

    @Override
    public void delete(TimeSlot timeSlot) {

    }

    @Override
    public void update(TimeSlot timeSlot) {

    }


    @Override
    public void create(Group group) {
        long nextGroupId = getGroups().size() + 1;
        group.setId(nextGroupId);
        getGroups().add(group);
    }

    @Override
    public void delete(Group group) {
        getGroups().remove(group);
    }

    @Override
    public void update(Group groupToBeUpdated) {
        int index = 0;
        for (Group group:getGroups()){
            if (group.equals(groupToBeUpdated)){
                break;
            }
            index++;
        }
        getGroups().set(index,groupToBeUpdated);
    }


}
