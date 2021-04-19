package com.realdolmen.padel.service;

import com.realdolmen.padel.data.BubbelsInMemoryDataStore;
import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.model.*;
import com.realdolmen.padel.model.builder.CourtTimeSlotBuilder;
import com.realdolmen.padel.model.builder.WeekBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;


@ExtendWith(SpringExtension.class)
public class BubbelsReservationServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(BubbelsReservationServiceImplTest.class);

    @Autowired
    private ReservationService reservationService;

    private List<Member> bubbelOneMenMembers;
    private List<Member> bubbelTwoMenMembers;
    private List<Member> bubbelThreeMenMembers;
    private List<Member> bubbelFourMenMembers;
    private List<Member> bubbelFiveMenMembers;
    private List<Member> bubbelSixMenMembers;
    private List<Member> bubbelSevenMenMembers;
    private List<Member> bubbelEightMenMembers;

    private List<Member> bubbelOneWomenMembers;
    private List<Member> bubbelTwoWomenMembers;
    private List<Member> bubbelThreeWomenMembers;
    private List<Member> bubbelFourWomenMembers;


    private Court courtOne;
    private Court courtTwo;

    private CourtTimeSlot thursdayAt1830OnCourt1;
    private CourtTimeSlot thursdayAt1830OnCourt2;

    private CourtTimeSlot thursdayAt2000OnCourt1;
    private CourtTimeSlot thursdayAt2000OnCourt2;

    private CourtTimeSlot thursdayAt2130OnCourt1;
    private CourtTimeSlot thursdayAt2130OnCourt2;


    private CourtTimeSlot mondayAt1830OnCourt1;
    private CourtTimeSlot mondayAt1830OnCourt2;

    private CourtTimeSlot mondayAt2000OnCourt1;
    private CourtTimeSlot mondayAt2000OnCourt2;

    private CourtTimeSlot mondayAt2130OnCourt1;
    private CourtTimeSlot mondayAt2130OnCourt2;



    private CourtTimeSlot tuesdayAt1830OnCourt1;
    private CourtTimeSlot tuesdayAt1830OnCourt2;

    private CourtTimeSlot tuesdayAt2000OnCourt1;
    private CourtTimeSlot tuesdayAt2000OnCourt2;

    private CourtTimeSlot tuesdayAt2130OnCourt1;
    private CourtTimeSlot tuesdayAt2130OnCourt2;

    private CourtTimeSlot wednesdayAt1830OnCourt1;
    private CourtTimeSlot wednesdayAt1830OnCourt2;

    private CourtTimeSlot wednesdayAt2000OnCourt1;
    private CourtTimeSlot wednesdayAt2000OnCourt2;

    private CourtTimeSlot wednesdayAt2130OnCourt1;
    private CourtTimeSlot wednesdayAt2130OnCourt2;

    @Autowired
    //@Qualifier("InMemoryMemberService")
    private MemberService memberService;

    @Autowired
    //@Qualifier("InMemoryCourtService")
    private CourtService courtService;

    @Autowired
    //@Qualifier("InMemoryCourtService")
    private GroupService groupService;

    LocalDate startDate;
    LocalDate endDate;


    @Autowired
    DataStore dataStore;

    @BeforeEach
    public void setUp() {


        dataStore.deleteAllReservations();
        //different padel group used for testing
        bubbelOneMenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_ONE_MEN);
        bubbelTwoMenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_TWO_MEN);
        bubbelThreeMenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_THREE_MEN);
        bubbelFourMenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_FOUR_MEN);
        bubbelFiveMenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_FIVE_MEN);
        bubbelSixMenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_SIX_MEN);
        bubbelSevenMenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_SEVEN_MEN);
        bubbelEightMenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_EIGHT_MEN);

        bubbelOneWomenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_ONE_WOMEN);
        bubbelTwoWomenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_TWO_WOMEN);
        bubbelThreeWomenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_THREE_WOMEN);
        bubbelFourWomenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_FOUR_WOMEN);


        //court used for testing
        courtOne = courtService.getCourt("1");
        courtTwo = courtService.getCourt("2");

        //timeslots used for testing
        thursdayAt1830OnCourt1 = new CourtTimeSlotBuilder().setId(1L).setTimeSlot(TimeSlot.TIME_SLOT_THURSDAY_1830_2000).setCourt(courtOne).build();
        thursdayAt1830OnCourt2 = new CourtTimeSlotBuilder().setId(2L).setTimeSlot(TimeSlot.TIME_SLOT_THURSDAY_1830_2000).setCourt(courtTwo).build();

        thursdayAt2000OnCourt1 = new CourtTimeSlotBuilder().setId(3L).setTimeSlot(TimeSlot.TIME_SLOT_THURSDAY_2000_2130).setCourt(courtOne).build();
        thursdayAt2000OnCourt2 = new CourtTimeSlotBuilder().setId(4L).setTimeSlot(TimeSlot.TIME_SLOT_THURSDAY_2000_2130).setCourt(courtTwo).build();

        thursdayAt2130OnCourt1 = new CourtTimeSlotBuilder().setId(5L).setTimeSlot(TimeSlot.TIME_SLOT_THURSDAY_2130_2300).setCourt(courtOne).build();
        thursdayAt2130OnCourt2 = new CourtTimeSlotBuilder().setId(6L).setTimeSlot(TimeSlot.TIME_SLOT_THURSDAY_2130_2300).setCourt(courtTwo).build();


        mondayAt1830OnCourt1 = new CourtTimeSlotBuilder().setId(7L).setTimeSlot(TimeSlot.TIME_SLOT_MONDAY_1830_2000).setCourt(courtOne).build();
        mondayAt1830OnCourt2 = new CourtTimeSlotBuilder().setId(8L).setTimeSlot(TimeSlot.TIME_SLOT_MONDAY_1830_2000).setCourt(courtTwo).build();

        mondayAt2000OnCourt1 = new CourtTimeSlotBuilder().setId(9L).setTimeSlot(TimeSlot.TIME_SLOT_MONDAY_2000_2130).setCourt(courtOne).build();
        mondayAt2000OnCourt2 = new CourtTimeSlotBuilder().setId(10L).setTimeSlot(TimeSlot.TIME_SLOT_MONDAY_2000_2130).setCourt(courtTwo).build();

        mondayAt2130OnCourt1 = new CourtTimeSlotBuilder().setId(5L).setTimeSlot(TimeSlot.TIME_SLOT_MONDAY_2130_2300).setCourt(courtOne).build();
        mondayAt2130OnCourt2 = new CourtTimeSlotBuilder().setId(6L).setTimeSlot(TimeSlot.TIME_SLOT_MONDAY_2130_2300).setCourt(courtTwo).build();


        tuesdayAt1830OnCourt1 = new CourtTimeSlotBuilder().setId(7L).setTimeSlot(TimeSlot.TIME_SLOT_TUESDAY_1830_2000).setCourt(courtOne).build();
        tuesdayAt1830OnCourt2 = new CourtTimeSlotBuilder().setId(8L).setTimeSlot(TimeSlot.TIME_SLOT_TUESDAY_1830_2000).setCourt(courtTwo).build();

        tuesdayAt2000OnCourt1 = new CourtTimeSlotBuilder().setId(9L).setTimeSlot(TimeSlot.TIME_SLOT_TUESDAY_2000_2130).setCourt(courtOne).build();
        tuesdayAt2000OnCourt2 = new CourtTimeSlotBuilder().setId(10L).setTimeSlot(TimeSlot.TIME_SLOT_TUESDAY_2000_2130).setCourt(courtTwo).build();

        tuesdayAt2130OnCourt1 = new CourtTimeSlotBuilder().setId(5L).setTimeSlot(TimeSlot.TIME_SLOT_TUESDAY_2130_2300).setCourt(courtOne).build();
        tuesdayAt2130OnCourt2 = new CourtTimeSlotBuilder().setId(6L).setTimeSlot(TimeSlot.TIME_SLOT_TUESDAY_2130_2300).setCourt(courtTwo).build();



        wednesdayAt1830OnCourt1 = new CourtTimeSlotBuilder().setId(7L).setTimeSlot(TimeSlot.TIME_SLOT_WEDNESDAY_1830_2000).setCourt(courtOne).build();
        wednesdayAt1830OnCourt2 = new CourtTimeSlotBuilder().setId(8L).setTimeSlot(TimeSlot.TIME_SLOT_WEDNESDAY_1830_2000).setCourt(courtTwo).build();

        wednesdayAt2000OnCourt1 = new CourtTimeSlotBuilder().setId(9L).setTimeSlot(TimeSlot.TIME_SLOT_WEDNESDAY_2000_2130).setCourt(courtOne).build();
        wednesdayAt2000OnCourt2 = new CourtTimeSlotBuilder().setId(10L).setTimeSlot(TimeSlot.TIME_SLOT_WEDNESDAY_2000_2130).setCourt(courtTwo).build();

        wednesdayAt2130OnCourt1 = new CourtTimeSlotBuilder().setId(5L).setTimeSlot(TimeSlot.TIME_SLOT_WEDNESDAY_2130_2300).setCourt(courtOne).build();
        wednesdayAt2130OnCourt2 = new CourtTimeSlotBuilder().setId(6L).setTimeSlot(TimeSlot.TIME_SLOT_WEDNESDAY_2130_2300).setCourt(courtTwo).build();


        //correct plan period
        startDate = LocalDate.of(2021, Month.APRIL,5);
        endDate = LocalDate.of(2021, Month.JULY, 5);

    }


    @Test
    public void generateWeekPlanningBubbelsTest() {

        WeekPlanningDisplay weekPlanningDisplay = new WeekPlanningDisplay();

        //weekly timeslots for bubbel one
        Map<Week, List<CourtTimeSlot>> bubbelOneCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));

        //generate weekplanning for bubbel one
        Set<WeekPlanning> bubbelOneWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelOneCourtTimeSlotListByWeek, bubbelOneMenMembers, groupService.getGroup(dataStore.BUBBEL_ONE_MEN),false);
        weekPlanningDisplay.displayPlanning(bubbelOneWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_ONE_MEN));


        //weekly timeslots for bubbel two
        Map<Week, List<CourtTimeSlot>> bubbelTwoCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelTwoCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));

        //generate weekplanning for bubbel two
        Set<WeekPlanning> bubbelTwoWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelTwoCourtTimeSlotListByWeek, bubbelTwoMenMembers, groupService.getGroup(dataStore.BUBBEL_TWO_MEN),false);
        weekPlanningDisplay.displayPlanning(bubbelTwoWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_TWO_MEN));


        //weekly timeslots for bubbel three
        Map<Week, List<CourtTimeSlot>> bubbelThreeCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelThreeCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));

        //generate weekplanning for bubbel three
        Set<WeekPlanning> bubbelThreeWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelThreeCourtTimeSlotListByWeek, bubbelThreeMenMembers, groupService.getGroup(dataStore.BUBBEL_THREE_MEN),false);
        weekPlanningDisplay.displayPlanning(bubbelThreeWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_THREE_MEN));



        //weekly timeslots for bubbel four
        Map<Week, List<CourtTimeSlot>> bubbelFourCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelFourCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));

        //generate weekplanning for bubbel four
        Set<WeekPlanning> bubbelFourWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelFourCourtTimeSlotListByWeek, bubbelFourMenMembers, groupService.getGroup(dataStore.BUBBEL_FOUR_MEN),false);
        weekPlanningDisplay.displayPlanning(bubbelFourWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_FOUR_MEN));


        //weekly timeslots for bubbel five
        Map<Week, List<CourtTimeSlot>> bubbelFiveCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(tuesdayAt2130OnCourt1,tuesdayAt2130OnCourt2));
        bubbelFiveCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));

        //generate weekplanning for bubbel five
        Set<WeekPlanning> bubbelFiveWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelFiveCourtTimeSlotListByWeek, bubbelFiveMenMembers, groupService.getGroup(dataStore.BUBBEL_FIVE_MEN),false);
        weekPlanningDisplay.displayPlanning(bubbelFiveWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_FIVE_MEN));


        //weekly timeslots for bubbel six
        Map<Week, List<CourtTimeSlot>> bubbelSixCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSixCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));


        //generate weekplanning for bubbel six
        Set<WeekPlanning> bubbelSixWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelSixCourtTimeSlotListByWeek, bubbelSixMenMembers, groupService.getGroup(dataStore.BUBBEL_SIX_MEN),false);
        weekPlanningDisplay.displayPlanning(bubbelSixWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_SIX_MEN));


        //weekly timeslots for bubbel seven
        Map<Week, List<CourtTimeSlot>> bubbelSevenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(mondayAt1830OnCourt1,mondayAt1830OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(mondayAt2000OnCourt1,mondayAt2000OnCourt2));
        bubbelSevenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(mondayAt2130OnCourt1,mondayAt2130OnCourt2));

        //generate weekplanning for bubbel seven
        Set<WeekPlanning> bubbelSevenWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelSevenCourtTimeSlotListByWeek, bubbelSevenMenMembers, groupService.getGroup(dataStore.BUBBEL_SEVEN_MEN),false);
        weekPlanningDisplay.displayPlanning(bubbelSevenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_SEVEN_MEN));


        //weekly timeslots for bubbel eight
        Map<Week, List<CourtTimeSlot>> bubbelEightCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(tuesdayAt1830OnCourt1,tuesdayAt1830OnCourt2));
        bubbelEightCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(tuesdayAt2000OnCourt1,tuesdayAt2000OnCourt2));

        //generate weekplanning for bubbel eight
        Set<WeekPlanning> bubbelEightWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelEightCourtTimeSlotListByWeek, bubbelEightMenMembers, groupService.getGroup(dataStore.BUBBEL_EIGHT_MEN),false);
        weekPlanningDisplay.displayPlanning(bubbelEightWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_EIGHT_MEN));



//weekly timeslots for bubbel one women
        Map<Week, List<CourtTimeSlot>> bubbelOneWomenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(wednesdayAt1830OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(wednesdayAt2000OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(wednesdayAt2130OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(wednesdayAt1830OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(wednesdayAt2000OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(wednesdayAt2130OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(wednesdayAt1830OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(wednesdayAt2000OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(wednesdayAt2130OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(wednesdayAt1830OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(wednesdayAt2000OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(wednesdayAt2130OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(wednesdayAt1830OnCourt1));
        bubbelOneWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(wednesdayAt2000OnCourt1));

        //generate weekplanning for bubbel one women
        Set<WeekPlanning> bubbelOneWomenWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelOneWomenCourtTimeSlotListByWeek, bubbelOneWomenMembers, groupService.getGroup(dataStore.BUBBEL_ONE_WOMEN),false);
        weekPlanningDisplay.displayPlanning(bubbelOneWomenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_ONE_WOMEN));



        //weekly timeslots for bubbel one women
        Map<Week, List<CourtTimeSlot>> bubbelTwoWomenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(wednesdayAt1830OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(wednesdayAt2000OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(wednesdayAt2130OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(wednesdayAt1830OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(wednesdayAt2000OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(wednesdayAt2130OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(wednesdayAt1830OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(wednesdayAt2000OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(wednesdayAt2130OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(wednesdayAt1830OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(wednesdayAt2000OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(wednesdayAt2130OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(wednesdayAt1830OnCourt2));
        bubbelTwoWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(wednesdayAt2000OnCourt2));

        //generate weekplanning for bubbel one women
        Set<WeekPlanning> bubbelTwoWomenWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelTwoWomenCourtTimeSlotListByWeek, bubbelTwoWomenMembers, groupService.getGroup(dataStore.BUBBEL_TWO_WOMEN),false);
        weekPlanningDisplay.displayPlanning(bubbelTwoWomenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_TWO_WOMEN));




        //weekly timeslots for bubbel three women
        Map<Week, List<CourtTimeSlot>> bubbelThreeWomenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelThreeWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));

        //generate weekplanning for bubbel three women
        Set<WeekPlanning> bubbelThreeWomenWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelThreeWomenCourtTimeSlotListByWeek, bubbelThreeWomenMembers, groupService.getGroup(dataStore.BUBBEL_THREE_WOMEN),false);
        weekPlanningDisplay.displayPlanning(bubbelThreeWomenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_THREE_WOMEN));


        //weekly timeslots for bubbel four women
        Map<Week, List<CourtTimeSlot>> bubbelFourWomenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(wednesdayAt2000OnCourt1,wednesdayAt2000OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(wednesdayAt2130OnCourt1,wednesdayAt2130OnCourt2));
        bubbelFourWomenCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(28).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JULY, 5)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 12)).build(), Arrays.asList(wednesdayAt1830OnCourt1,wednesdayAt1830OnCourt2));

        //generate weekplanning for bubbel four
        Set<WeekPlanning> bubbelFourWomenWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelFourWomenCourtTimeSlotListByWeek, bubbelFourWomenMembers, groupService.getGroup(dataStore.BUBBEL_FOUR_WOMEN),false);
        weekPlanningDisplay.displayPlanning(bubbelFourWomenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_FOUR_WOMEN));







    }

    @TestConfiguration
    static class ReservationServiceImplTestContextConfiguration {

        @Bean
        public ReservationService reservationService() {
            return new ReservationServiceImpl();
        }

        @Bean
        //@Bean("InMemoryMemberService")
        public MemberService memberService() {
            return new InMemoryMemberService();
        }


//        @Bean("InMemoryCourtService")
        @Bean
        public CourtService courtService() {
            return new InMemoryCourtService();
        }

        @Bean
        public GroupService groupService() {
            return new InMemoryGroupService();
        }




        @Bean
        public DataStore dataSource() {
            return new BubbelsInMemoryDataStore();
        }


    }



}
