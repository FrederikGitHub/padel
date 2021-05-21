package com.realdolmen.padel.data;

import com.realdolmen.padel.model.*;
import com.realdolmen.padel.model.builder.MemberBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.padel.model.Availability.*;

@Component
public class BubbelsInMemoryDataStore implements DataStore{


    private static List<Reservation> reservations=new ArrayList<Reservation>();

    private static List<Group> clubGroups =new ArrayList<Group>();

    private static List<VtvLevel> vtvLevels=new ArrayList<VtvLevel>();

    private static List<Availability> availabilities =new ArrayList<Availability>();

    private static List<TimeSlot> timeSlots =new ArrayList<TimeSlot>();

    private static List<Court> courtList=new ArrayList<Court>();

    private static List<String> genders=new ArrayList<String>();

    private static List<CourtTimeSlot> courtTimeSlots =new ArrayList<CourtTimeSlot>();


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


    static{
        courtList.add(new Court(1L,"1"));
        courtList.add(new Court(2L,"2"));
    }


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

    }


    static{
        clubGroups.add(new Group(1L,P50_WOMEN,Arrays.asList(P50_LEVEL),"Y"));
        clubGroups.add(new Group(2L,P100_WOMEN,Arrays.asList(P100_LEVEL),"Y"));
        clubGroups.add(new Group(3L,P100_MEN,Arrays.asList(P100_LEVEL),"Y"));
        clubGroups.add(new Group(4L,P200_MEN,Arrays.asList(P200_LEVEL),"Y"));
        clubGroups.add(new Group(5L,P200_WOMEN,Arrays.asList(P200_LEVEL),"Y"));
        clubGroups.add(new Group(6L,P300_MEN,Arrays.asList(P300_LEVEL),"Y"));
        clubGroups.add(new Group(7L,P500_MEN,Arrays.asList(P500_LEVEL),"Y"));
        clubGroups.add(new Group(8L,DUMMY_GROUP,Arrays.asList(P500_LEVEL),"N"));

        clubGroups.add(new Group(9L, BUBBEL_ONE_MEN,Arrays.asList(P500_LEVEL,P300_LEVEL),"Y"));
        clubGroups.add(new Group(10L, BUBBEL_TWO_MEN,Arrays.asList(P500_LEVEL,P300_LEVEL),"Y"));
        clubGroups.add(new Group(11L, BUBBEL_THREE_MEN,Arrays.asList(P300_LEVEL,P200_LEVEL),"Y"));
        clubGroups.add(new Group(12L, BUBBEL_FOUR_MEN,Arrays.asList(P200_LEVEL),"Y"));
        clubGroups.add(new Group(13L, BUBBEL_FIVE_MEN,Arrays.asList(P200_LEVEL),"Y"));
        clubGroups.add(new Group(14L, BUBBEL_SIX_MEN,Arrays.asList(P200_LEVEL),"Y"));
        clubGroups.add(new Group(15L, BUBBEL_SEVEN_MEN,Arrays.asList(P100_LEVEL),"Y"));
        clubGroups.add(new Group(16L, BUBBEL_EIGHT_MEN,Arrays.asList(P100_LEVEL),"Y"));
        clubGroups.add(new Group(15L, BUBBEL_ONE_WOMEN,Arrays.asList(P100_LEVEL),"Y"));
        clubGroups.add(new Group(16L, BUBBEL_TWO_WOMEN,Arrays.asList(P100_LEVEL),"Y"));
        clubGroups.add(new Group(17L, BUBBEL_THREE_WOMEN,Arrays.asList(P100_LEVEL),"Y"));
        clubGroups.add(new Group(18L, BUBBEL_FOUR_WOMEN,Arrays.asList(P100_LEVEL),"Y"));
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
        courtTimeSlots.add(new CourtTimeSlot(1L,timeSlots.get(0),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(2L,timeSlots.get(0),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(3L,timeSlots.get(1),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(4L,timeSlots.get(1),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(5L,timeSlots.get(2),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(6L,timeSlots.get(2),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(7L,timeSlots.get(3),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(8L,timeSlots.get(4),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(9L,timeSlots.get(5),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(10L,timeSlots.get(5),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(11L,timeSlots.get(6),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(12L,timeSlots.get(6),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(13L,timeSlots.get(7),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(14L,timeSlots.get(7),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(15L,timeSlots.get(8),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(16L,timeSlots.get(8),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(17L,timeSlots.get(9),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(18L,timeSlots.get(9),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(19L,timeSlots.get(10),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(20L,timeSlots.get(10),courtList.get(1)));

        courtTimeSlots.add(new CourtTimeSlot(21L,timeSlots.get(11),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(22L,timeSlots.get(11),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(23L,timeSlots.get(12),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(24L,timeSlots.get(12),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(25L,timeSlots.get(13),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(26L,timeSlots.get(13),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(27L,timeSlots.get(14),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(28L,timeSlots.get(14),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(29L,timeSlots.get(15),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(30L,timeSlots.get(15),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(31L,timeSlots.get(16),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(32L,timeSlots.get(16),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(33L,timeSlots.get(17),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(34L,timeSlots.get(17),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(35L,timeSlots.get(18),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(36L,timeSlots.get(18),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(37L,timeSlots.get(19),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(38L,timeSlots.get(19),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(39L,timeSlots.get(20),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(40L,timeSlots.get(20),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(41L,timeSlots.get(21),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(42L,timeSlots.get(21),courtList.get(1)));

        courtTimeSlots.add(new CourtTimeSlot(43L,timeSlots.get(22),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(44L,timeSlots.get(22),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(45L,timeSlots.get(23),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(46L,timeSlots.get(23),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(47L,timeSlots.get(24),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(48L,timeSlots.get(24),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(49L,timeSlots.get(25),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(50L,timeSlots.get(25),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(51L,timeSlots.get(26),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(52L,timeSlots.get(26),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(53L,timeSlots.get(27),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(54L,timeSlots.get(27),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(55L,timeSlots.get(28),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(56L,timeSlots.get(28),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(57L,timeSlots.get(29),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(58L,timeSlots.get(29),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(59L,timeSlots.get(30),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(60L,timeSlots.get(30),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(61L,timeSlots.get(31),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(62L,timeSlots.get(31),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(63L,timeSlots.get(32),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(64L,timeSlots.get(32),courtList.get(1)));


        courtTimeSlots.add(new CourtTimeSlot(65L,timeSlots.get(33),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(66L,timeSlots.get(33),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(67L,timeSlots.get(34),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(68L,timeSlots.get(34),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(69L,timeSlots.get(35),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(70L,timeSlots.get(35),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(71L,timeSlots.get(36),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(72L,timeSlots.get(36),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(73L,timeSlots.get(37),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(74L,timeSlots.get(37),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(75L,timeSlots.get(38),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(76L,timeSlots.get(38),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(77L,timeSlots.get(39),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(78L,timeSlots.get(39),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(79L,timeSlots.get(40),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(80L,timeSlots.get(40),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(81L,timeSlots.get(41),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(82L,timeSlots.get(41),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(83L,timeSlots.get(42),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(84L,timeSlots.get(42),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(85L,timeSlots.get(43),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(86L,timeSlots.get(43),courtList.get(1)));


        courtTimeSlots.add(new CourtTimeSlot(87L,timeSlots.get(44),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(88L,timeSlots.get(44),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(89L,timeSlots.get(45),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(90L,timeSlots.get(45),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(91L,timeSlots.get(46),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(92L,timeSlots.get(46),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(93L,timeSlots.get(47),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(94L,timeSlots.get(47),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(95L,timeSlots.get(48),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(96L,timeSlots.get(48),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(97L,timeSlots.get(49),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(98L,timeSlots.get(49),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(99L,timeSlots.get(50),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(100L,timeSlots.get(50),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(101L,timeSlots.get(51),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(102L,timeSlots.get(51),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(103L,timeSlots.get(52),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(104L,timeSlots.get(52),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(105L,timeSlots.get(53),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(106L,timeSlots.get(53),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(107L,timeSlots.get(54),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(108L,timeSlots.get(54),courtList.get(1)));


        courtTimeSlots.add(new CourtTimeSlot(109L,timeSlots.get(55),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(110L,timeSlots.get(55),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(111L,timeSlots.get(56),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(112L,timeSlots.get(56),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(113L,timeSlots.get(57),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(114L,timeSlots.get(57),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(115L,timeSlots.get(58),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(116L,timeSlots.get(58),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(117L,timeSlots.get(59),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(118L,timeSlots.get(59),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(119L,timeSlots.get(60),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(120L,timeSlots.get(60),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(121L,timeSlots.get(61),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(122L,timeSlots.get(61),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(123L,timeSlots.get(62),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(124L,timeSlots.get(62),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(125L,timeSlots.get(63),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(126L,timeSlots.get(63),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(127L,timeSlots.get(64),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(128L,timeSlots.get(64),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(129L,timeSlots.get(65),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(130L,timeSlots.get(65),courtList.get(1)));


        courtTimeSlots.add(new CourtTimeSlot(131L,timeSlots.get(66),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(132L,timeSlots.get(66),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(133L,timeSlots.get(67),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(134L,timeSlots.get(67),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(135L,timeSlots.get(68),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(136L,timeSlots.get(68),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(137L,timeSlots.get(69),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(138L,timeSlots.get(69),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(139L,timeSlots.get(70),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(140L,timeSlots.get(70),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(141L,timeSlots.get(71),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(142L,timeSlots.get(71),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(143L,timeSlots.get(72),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(144L,timeSlots.get(72),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(145L,timeSlots.get(73),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(146L,timeSlots.get(73),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(147L,timeSlots.get(74),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(148L,timeSlots.get(74),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(149L,timeSlots.get(75),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(150L,timeSlots.get(75),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(151L,timeSlots.get(76),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(152L,timeSlots.get(76),courtList.get(1)));

    }





    private static List<Member> bubbelMembers=new ArrayList<Member>();

    static{
        //BEGIN BUBBEL_ONE_MEN
        bubbelMembers.add(new MemberBuilder().setId(1L).setName("D'hose").setFirstName("Kris").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(2L).setName("Goossens").setFirstName("Werner").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(3L).setName("Stalpaert").setFirstName("Bart").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(4L).setName("Vandevelde").setFirstName("Tom").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(5L).setName("Vanhee").setFirstName("Kris").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(6L).setName("Verplanken").setFirstName("Christophe").setActive("Y").setLevel(P500_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(7L).setName("Van Heddeghem").setFirstName("Frederik").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(8L).setName("Dirk").setFirstName("Demil").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(9L).setName("Uyttenhove").setFirstName("Dries").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(10L).setName("Van Wymeersch").setFirstName("Tim").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_MEN)))).build());
        //END BUBBEL_ONE_MEN

        //BEGIN BUBBEL_TWO_MEN
        bubbelMembers.add(new MemberBuilder().setId(11L).setName("De Smedt").setFirstName("Dominik").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(12L).setName("Leroy").setFirstName("Pedro").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(13L).setName("Torrekens").setFirstName("Bruno").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(14L).setName("Van Huffel").setFirstName("Diego").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(15L).setName("Verstichelen").setFirstName("Davy").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(16L).setName("De Smet Van Damme").setFirstName("Jan").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(17L).setName("D'Hoker").setFirstName("Pieter").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(18L).setName("Capelleman").setFirstName("Philip").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(19L).setName("Paternoster").setFirstName("Stefaan").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(20L).setName("Baeyens").setFirstName("Brecht").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        //END BUBBEL_TWO

        //BEGIN BUBBEL_THREE_MEN
        bubbelMembers.add(new MemberBuilder().setId(21L).setName("De Clercq").setFirstName("Stijn").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(22L).setName("Coesens").setFirstName("Joris").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(23L).setName("Collage").setFirstName("Kristof").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(24L).setName("Delestree").setFirstName("Jasper").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(25L).setName("Temmerman").setFirstName("Dirk").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(26L).setName("vanhee").setFirstName("Dieter").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(27L).setName("Janssens").setFirstName("Johan").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(28L).setName("Verstuyft").setFirstName("Joeri").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(29L).setName("Van Schoors").setFirstName("Erik").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(30L).setName("Verplanken").setFirstName("Marco").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        //END BUBBEL_THREE_MEN

        //BEGIN BUBBEL_FOUR_MEN
        bubbelMembers.add(new MemberBuilder().setId(31L).setName("De Backer").setFirstName("Bart").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(32L).setName("Boone").setFirstName("Tom").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(33L).setName("De Cock").setFirstName("Jurgen").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(34L).setName("Demeester").setFirstName("Jan").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(35L).setName("Van Haesevelde").setFirstName("Ellert").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(36L).setName("Van Lierde").setFirstName("Filip").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(37L).setName("Paternoster").setFirstName("Kris").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(38L).setName("Peereman").setFirstName("Frederik").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(39L).setName("De Saegher").setFirstName("Christian").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        //END BUBBEL_FOUR_MEN

        //BEGIN BUBBEL_FIVE_MEN
        bubbelMembers.add(new MemberBuilder().setId(40L).setName("Cruypelinck").setFirstName("Xavier").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(41L).setName("De Smet").setFirstName("Bjorn").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(42L).setName("De Vlaminck").setFirstName("Steve").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(43L).setName("Jacobs").setFirstName("Micha").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(44L).setName("Broodcoorens").setFirstName("Jarno").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(45L).setName("Liedts").setFirstName("Jens").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(46L).setName("Thomas").setFirstName("Bram").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(47L).setName("Van Audenhove").setFirstName("Wesley").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(48L).setName("Van Cauwenberge").setFirstName("Koen").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(49L).setName("Vande Pontseele").setFirstName("Ronny").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FIVE_MEN)))).build());
        //END BUBBEL_FIVE_MEN


        //BEGIN BUBBEL_SIX_MEN
        bubbelMembers.add(new MemberBuilder().setId(50L).setName("De Bruycker").setFirstName("Pieter").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(51L).setName("De Bruyne").setFirstName("Benny").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(52L).setName("Demeester").setFirstName("Kenneth").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(53L).setName("D'Haenens").setFirstName("Kenny").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(54L).setName("Hermie").setFirstName("Frank").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(55L).setName("Martens").setFirstName("Davy").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(56L).setName("Nies").setFirstName("Bert").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(57L).setName("Van Haesevelde").setFirstName("Patrick").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(58L).setName("Van Paemel").setFirstName("Jordi").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(59L).setName("Hendryckx").setFirstName("Joachim").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SIX_MEN)))).build());
        //END BUBBEL_SIX_MEN

        //BEGIN BUBBEL_SEVEN_MEN
        bubbelMembers.add(new MemberBuilder().setId(60L).setName("De Cloedt").setFirstName("Fabian").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(61L).setName("De Durpel").setFirstName("Kas").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(62L).setName("Leeman").setFirstName("Hans").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(63L).setName("Van der Heyden").setFirstName("Pieter").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(64L).setName("Van Der Biest").setFirstName("Andy").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(65L).setName("Van der Heyden").setFirstName("Gerd").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(66L).setName("Van Grootenbrulle").setFirstName("Jens").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(67L).setName("Van Grootenbrulle").setFirstName("Kurt").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(68L).setName("Vandesande").setFirstName("Steven").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(69L).setName("Vlassenbroek").setFirstName("Wim").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_SEVEN_MEN)))).build());
        //END BUBBEL_SEVEN_MEN

        //BEGIN BUBBEL_EIGHT_MEN
        bubbelMembers.add(new MemberBuilder().setId(70L).setName("Barbe").setFirstName("Koen").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(71L).setName("Eeckhout").setFirstName("Guido").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(72L).setName("Van De Capelle").setFirstName("Geert").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(73L).setName("Galle").setFirstName("Gunter").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(74L).setName("Jacobs").setFirstName("Jasper").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(75L).setName("Leroy").setFirstName("Willy").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(76L).setName("Tondeur").setFirstName("Steven").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(77L).setName("Roeland").setFirstName("Tom").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(78L).setName("Collier").setFirstName("Johan").setActive("Y").setLevel(P100_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_EIGHT_MEN)))).build());
        //END BUBBEL_EIGHT_MEN


        //BEGIN BUBBEL_ONE_WOMEN
        bubbelMembers.add(new MemberBuilder().setId(79L).setName("Cortier").setFirstName("Kathy").setActive("Y").setLevel(P200_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(80L).setName("De Clercq").setFirstName("Erika").setActive("Y").setLevel(P200_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(81L).setName("Diependaele").setFirstName("Ilse").setActive("Y").setLevel(P200_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(82L).setName("Van Den Driessche").setFirstName("Katrien").setActive("Y").setLevel(P200_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(83L).setName("Reyns").setFirstName("Liesbet").setActive("Y").setLevel(P200_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(84L).setName("Steeman").setFirstName("Veerle").setActive("Y").setLevel(P200_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_ONE_WOMEN)))).build());
        //END BUBBEL_ONE_WOMEN

        //BEGIN BUBBEL_TWO_WOMEN
        bubbelMembers.add(new MemberBuilder().setId(85L).setName("De Cock").setFirstName("Sabrina").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(86L).setName("De Kegel").setFirstName("Inge").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(87L).setName("De Mets").setFirstName("Annick").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(88L).setName("De Sutter").setFirstName("Evy").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(89L).setName("Vanhee").setFirstName("Phebe").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(90L).setName("Van Schoors").setFirstName("Jessica").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_WOMEN)))).build());
        //END BUBBEL_TWO_WOMEN

        //BEGIN BUBBEL_THREE_WOMEN
        bubbelMembers.add(new MemberBuilder().setId(91L).setName("Eeckhout").setFirstName("Anja").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(92L).setName("Bourlez").setFirstName("Karen").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(93L).setName("De Groote").setFirstName("Sara").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(94L).setName("Delmaire").setFirstName("Veronique").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(95L).setName("Wijnant").setFirstName("Ellen").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(96L).setName("De Groote").setFirstName("Els").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(97L).setName("Mertens").setFirstName("Petra").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(98L).setName("Van Den Bossche").setFirstName("Josephine").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(99L).setName("Vanhee").setFirstName("Paulien").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(100L).setName("Hantson").setFirstName("Veroniqie").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_WOMEN)))).build());
        //END BUBBEL_THREE_WOMEN


        //BEGIN BUBBEL_FOUR_WOMEN
        bubbelMembers.add(new MemberBuilder().setId(101L).setName("Bource").setFirstName("Emilie").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(102L).setName("Dubois").setFirstName("Vanessa").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(103L).setName("Geerts").setFirstName("Vicky").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(104L).setName("Kiekens").setFirstName("Mieke").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(105L).setName("Laureyns").setFirstName("Els").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(106L).setName("Pieters").setFirstName("Nele").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(107L).setName("Roelandt").setFirstName("Shani").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(108L).setName("Santinacci").setFirstName("Sofia").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(109L).setName("Van Cutsem").setFirstName("Nele").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(110L).setName("Van Huffel").setFirstName("Natasha").setActive("Y").setLevel(P100_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_WOMEN)))).build());
        //END BUBBEL_FOUR_WOMEN





















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
        return bubbelMembers;
    }

    public List<Court> getCourtList(){
        return courtList;
    }

    public List<VtvLevel> getVtvLevels(){
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

    @Override
    public List<CourtTimeSlot> getCourtTimeSlots() {
        return courtTimeSlots;
    }
}
