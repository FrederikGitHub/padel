package com.realdolmen.padel.data;

import com.realdolmen.padel.model.*;
import com.realdolmen.padel.model.builder.MemberBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.padel.model.Availability.*;

@Component
public class InMemoryDataStore implements DataStore{



    private static List<Reservation> reservations=new ArrayList<Reservation>();

    private static List<Group> clubGroups =new ArrayList<Group>();

    private static List<VtvLevel> vtvLevels=new ArrayList<VtvLevel>();

    private static List<Availability> availabilities =new ArrayList<Availability>();

    private static List<TimeSlot> timeSlots =new ArrayList<TimeSlot>();

    private static List<Court> courtList=new ArrayList<Court>();

    private static List<String> genders=new ArrayList<String>();

    private static List<CourtTimeSlot> courtTimeSlots =new ArrayList<CourtTimeSlot>();


    static{
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
        courtTimeSlots.add(new CourtTimeSlot(2L,timeSlots.get(1),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(3L,timeSlots.get(2),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(4L,timeSlots.get(3),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(5L,timeSlots.get(4),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(6L,timeSlots.get(5),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(7L,timeSlots.get(6),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(8L,timeSlots.get(7),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(9L,timeSlots.get(8),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(10L,timeSlots.get(9),courtList.get(0)));

        courtTimeSlots.add(new CourtTimeSlot(11L,timeSlots.get(10),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(12L,timeSlots.get(11),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(13L,timeSlots.get(12),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(14L,timeSlots.get(13),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(15L,timeSlots.get(14),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(16L,timeSlots.get(15),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(17L,timeSlots.get(16),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(18L,timeSlots.get(17),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(19L,timeSlots.get(18),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(20L,timeSlots.get(19),courtList.get(0)));

        courtTimeSlots.add(new CourtTimeSlot(21L,timeSlots.get(20),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(22L,timeSlots.get(21),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(23L,timeSlots.get(22),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(24L,timeSlots.get(23),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(25L,timeSlots.get(24),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(26L,timeSlots.get(25),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(27L,timeSlots.get(26),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(28L,timeSlots.get(27),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(29L,timeSlots.get(28),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(30L,timeSlots.get(29),courtList.get(0)));

        courtTimeSlots.add(new CourtTimeSlot(31L,timeSlots.get(30),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(32L,timeSlots.get(31),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(33L,timeSlots.get(32),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(34L,timeSlots.get(33),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(35L,timeSlots.get(34),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(36L,timeSlots.get(35),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(37L,timeSlots.get(36),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(38L,timeSlots.get(37),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(39L,timeSlots.get(38),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(40L,timeSlots.get(39),courtList.get(0)));


        courtTimeSlots.add(new CourtTimeSlot(41L,timeSlots.get(40),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(42L,timeSlots.get(41),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(43L,timeSlots.get(42),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(44L,timeSlots.get(43),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(45L,timeSlots.get(44),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(46L,timeSlots.get(45),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(47L,timeSlots.get(46),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(48L,timeSlots.get(47),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(49L,timeSlots.get(48),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(50L,timeSlots.get(49),courtList.get(0)));

        courtTimeSlots.add(new CourtTimeSlot(51L,timeSlots.get(50),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(52L,timeSlots.get(51),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(53L,timeSlots.get(52),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(54L,timeSlots.get(53),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(55L,timeSlots.get(54),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(56L,timeSlots.get(55),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(57L,timeSlots.get(56),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(58L,timeSlots.get(57),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(59L,timeSlots.get(58),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(60L,timeSlots.get(59),courtList.get(0)));

        courtTimeSlots.add(new CourtTimeSlot(61L,timeSlots.get(60),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(62L,timeSlots.get(61),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(63L,timeSlots.get(62),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(64L,timeSlots.get(63),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(65L,timeSlots.get(64),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(66L,timeSlots.get(65),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(67L,timeSlots.get(66),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(68L,timeSlots.get(67),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(69L,timeSlots.get(68),courtList.get(0)));
        courtTimeSlots.add(new CourtTimeSlot(70L,timeSlots.get(69),courtList.get(0)));

        courtTimeSlots.add(new CourtTimeSlot(71L,timeSlots.get(0),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(72L,timeSlots.get(1),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(73L,timeSlots.get(2),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(74L,timeSlots.get(3),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(75L,timeSlots.get(4),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(76L,timeSlots.get(5),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(77L,timeSlots.get(6),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(78L,timeSlots.get(7),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(79L,timeSlots.get(8),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(80L,timeSlots.get(9),courtList.get(1)));

        courtTimeSlots.add(new CourtTimeSlot(81L,timeSlots.get(10),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(82L,timeSlots.get(11),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(83L,timeSlots.get(12),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(84L,timeSlots.get(13),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(85L,timeSlots.get(14),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(86L,timeSlots.get(15),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(87L,timeSlots.get(16),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(88L,timeSlots.get(17),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(89L,timeSlots.get(18),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(90L,timeSlots.get(19),courtList.get(1)));

        courtTimeSlots.add(new CourtTimeSlot(91L,timeSlots.get(20),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(92L,timeSlots.get(21),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(93L,timeSlots.get(22),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(94L,timeSlots.get(23),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(95L,timeSlots.get(24),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(96L,timeSlots.get(25),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(97L,timeSlots.get(26),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(98L,timeSlots.get(27),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(99L,timeSlots.get(28),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(100L,timeSlots.get(29),courtList.get(1)));

        courtTimeSlots.add(new CourtTimeSlot(101L,timeSlots.get(30),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(102L,timeSlots.get(31),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(103L,timeSlots.get(32),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(104L,timeSlots.get(33),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(105L,timeSlots.get(34),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(106L,timeSlots.get(35),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(107L,timeSlots.get(36),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(108L,timeSlots.get(37),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(109L,timeSlots.get(38),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(110L,timeSlots.get(39),courtList.get(1)));


        courtTimeSlots.add(new CourtTimeSlot(111L,timeSlots.get(40),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(112L,timeSlots.get(41),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(113L,timeSlots.get(42),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(114L,timeSlots.get(43),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(115L,timeSlots.get(44),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(116L,timeSlots.get(45),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(117L,timeSlots.get(46),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(118L,timeSlots.get(47),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(119L,timeSlots.get(48),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(120L,timeSlots.get(49),courtList.get(1)));

        courtTimeSlots.add(new CourtTimeSlot(121L,timeSlots.get(50),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(122L,timeSlots.get(51),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(123L,timeSlots.get(52),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(124L,timeSlots.get(53),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(125L,timeSlots.get(54),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(126L,timeSlots.get(55),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(127L,timeSlots.get(56),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(128L,timeSlots.get(57),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(129L,timeSlots.get(58),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(130L,timeSlots.get(59),courtList.get(1)));

        courtTimeSlots.add(new CourtTimeSlot(131L,timeSlots.get(60),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(132L,timeSlots.get(61),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(133L,timeSlots.get(62),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(134L,timeSlots.get(63),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(135L,timeSlots.get(64),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(136L,timeSlots.get(65),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(137L,timeSlots.get(66),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(138L,timeSlots.get(67),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(139L,timeSlots.get(68),courtList.get(1)));
        courtTimeSlots.add(new CourtTimeSlot(140L,timeSlots.get(69),courtList.get(1)));


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
        padelMembers.add(new MemberBuilder().setId(9L).setName("Uyttenhove").setFirstName("Dries").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.SECOND_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(Availability.FIRST_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());


        //P300H,second week of month part of P500H
        padelMembers.add(new MemberBuilder().setId(10L).setName("Van Wymeersch").setFirstName("Tim").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FIRST_THIRD_FOURTH_FIFTH_WEEK_AVAILABILITY,getPadelGroup(P300_MEN)),new GroupAvailability(SECOND_WEEK_AVAILABILITY,getPadelGroup(P500_MEN)))).build());
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


    private static List<Member> bubbelMembers=new ArrayList<Member>();

    static{
        //BEGIN BUBBEL_ONE
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
        //END BUBBEL_ONE

        //BEGIN BUBBEL_TWO
        bubbelMembers.add(new MemberBuilder().setId(11L).setName("De Smedt").setFirstName("Dominik").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(12L).setName("Leroy").setFirstName("Pedro").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(13L).setName("Torrekens").setFirstName("Bruno").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(14L).setName("Van Huffel").setFirstName("Diego").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(15L).setName("Verstichelen").setFirstName("Davy").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(16L).setName("De Smet Van Damme").setFirstName("Jan").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(17L).setName("D'Hoker").setFirstName("Pieter").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(18L).setName("Leroy").setFirstName("Wendy").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(19L).setName("Paternoster").setFirstName("Stefaan").setActive("Y").setLevel(P300_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(20L).setName("Baeyens").setFirstName("Brecht").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_TWO_MEN)))).build());
        //END BUBBEL_TWO


        //BEGIN BUBBEL_THREE
        bubbelMembers.add(new MemberBuilder().setId(21L).setName("Capelleman").setFirstName("Philip").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(22L).setName("Coesens").setFirstName("Joris").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(23L).setName("Collage").setFirstName("Kristof").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(24L).setName("Cortier").setFirstName("Kathy").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(25L).setName("De Backer").setFirstName("Bart").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(26L).setName("De Brakeleer").setFirstName("Kristof").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(27L).setName("Janssens").setFirstName("Johan").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(28L).setName("Paternoster").setFirstName("Kris").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(29L).setName("Peereman").setFirstName("Frederik").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(30L).setName("Reyns").setFirstName("Liesbet").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_THREE_MEN)))).build());
        //END BUBBEL_THREE

        //BEGIN BUBBEL_FOUR
        bubbelMembers.add(new MemberBuilder().setId(31L).setName("De Clercq").setFirstName("Stijn").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(32L).setName("De Cock").setFirstName("Jurgen").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(33L).setName("Delestrée").setFirstName("Jasper").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(34L).setName("De Meester").setFirstName("Jan").setActive("Y").setLevel(P200_LEVEL).setGender(WOMEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(35L).setName("Diependaele").setFirstName("Ilse").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(36L).setName("Eeckhout").setFirstName("Andy").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(37L).setName("Van Haesevelde").setFirstName("Ellert").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(38L).setName("Vanhee").setFirstName("Dieter").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(39L).setName("Verplanken").setFirstName("Marco").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        bubbelMembers.add(new MemberBuilder().setId(40L).setName("Verstuyft").setFirstName("Joeri").setActive("Y").setLevel(P200_LEVEL).setGender(MEN).setGroupAvailabilityList(Arrays.asList(new GroupAvailability(Availability.FULL_TIME_AVAILABILITY,getPadelGroup(BUBBEL_FOUR_MEN)))).build());
        //END BUBBEL_FOUR

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

    @Override
    public Reservation findReservation(CourtTimeSlot courtTimeSlot, LocalDate localDate) {
        Reservation reservation=null;
        if (!CollectionUtils.isEmpty(reservations)){
            Optional<Reservation> optionalReservation = reservations.stream().filter(Reservation.Predicates.withCourtTimeSlot(courtTimeSlot).and(Reservation.Predicates.withDate(localDate))).findFirst();
            if (optionalReservation.isPresent()){
                reservation = optionalReservation.get();
            }
        }
        return reservation;
    }

    public List<Member> getPadelMembers(){
        return padelMembers;
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
    public void create(WeeklyReserve weeklyReserve) {

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
