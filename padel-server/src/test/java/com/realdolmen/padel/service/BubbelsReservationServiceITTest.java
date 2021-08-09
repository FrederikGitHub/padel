package com.realdolmen.padel.service;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BubbelsReservationServiceITTest {

    private static final Logger logger = LoggerFactory.getLogger(BubbelsReservationServiceITTest.class);

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
    private MemberService memberService;

    @Autowired
    private CourtService courtService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private CourtTimeSlotService courtTimeSlotService;

    @Autowired
    private TimeSlotService timeSlotService;

    LocalDate startDate;
    LocalDate endDate;


    @Autowired
    DataStore dataStore;

    @BeforeEach
    public void setUp() {


        //dataStore.deleteAllReservations();
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
        courtOne = courtService.getCourt("COURT1");
        courtTwo = courtService.getCourt("COURT2");

        //timeslots used for testing
        thursdayAt1830OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_THURSDAY_1830_2000);
        thursdayAt1830OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_THURSDAY_1830_2000);

        thursdayAt2000OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_THURSDAY_2000_2130);
        thursdayAt2000OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_THURSDAY_2000_2130);

        thursdayAt2130OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_THURSDAY_2130_2300);
        thursdayAt2130OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_THURSDAY_2130_2300);


        mondayAt1830OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_MONDAY_1830_2000);
        mondayAt1830OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_MONDAY_1830_2000);

        mondayAt2000OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_MONDAY_2000_2130);
        mondayAt2000OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_MONDAY_2000_2130);

        mondayAt2130OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_MONDAY_2130_2300);
        mondayAt2130OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_MONDAY_2130_2300);


        tuesdayAt1830OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_TUESDAY_1830_2000);
        tuesdayAt1830OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_TUESDAY_1830_2000);

        tuesdayAt2000OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_TUESDAY_2000_2130);
        tuesdayAt2000OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_TUESDAY_2000_2130);

        tuesdayAt2130OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_TUESDAY_2130_2300);
        tuesdayAt2130OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_TUESDAY_2130_2300);



        wednesdayAt1830OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_WEDNESDAY_1830_2000);
        wednesdayAt1830OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_WEDNESDAY_1830_2000);

        wednesdayAt2000OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_WEDNESDAY_2000_2130);
        wednesdayAt2000OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_WEDNESDAY_2000_2130);

        wednesdayAt2130OnCourt1 = courtTimeSlotService.findCourtTimeSlot(courtOne,TimeSlot.TIME_SLOT_WEDNESDAY_2130_2300);
        wednesdayAt2130OnCourt2 = courtTimeSlotService.findCourtTimeSlot(courtTwo,TimeSlot.TIME_SLOT_WEDNESDAY_2130_2300);


        //correct plan period
        startDate = LocalDate.of(2021, Month.MAY,3);
        endDate = LocalDate.of(2021, Month.JULY, 5);

    }


    @Test
    public void generateWeekPlanningBubbelsITTest() {

        WeekPlanningDisplay weekPlanningDisplay = new WeekPlanningDisplay();

        //weekly timeslots for bubbel one
        Map<Week, List<CourtTimeSlot>> bubbelOneCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelOneWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelOneWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_ONE_MEN));


        //weekly timeslots for bubbel two
        Map<Week, List<CourtTimeSlot>> bubbelTwoCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelTwoWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelTwoWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_TWO_MEN));


        //weekly timeslots for bubbel three
        Map<Week, List<CourtTimeSlot>> bubbelThreeCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelThreeWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelThreeWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_THREE_MEN));



        //weekly timeslots for bubbel four
        Map<Week, List<CourtTimeSlot>> bubbelFourCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelFourWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelFourWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_FOUR_MEN));


        //weekly timeslots for bubbel five
        Map<Week, List<CourtTimeSlot>> bubbelFiveCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelFiveWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelFiveWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_FIVE_MEN));


        //weekly timeslots for bubbel six
        Map<Week, List<CourtTimeSlot>> bubbelSixCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelSixWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelSixWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_SIX_MEN));


        //weekly timeslots for bubbel seven
        Map<Week, List<CourtTimeSlot>> bubbelSevenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelSevenWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelSevenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_SEVEN_MEN));


        //weekly timeslots for bubbel eight
        Map<Week, List<CourtTimeSlot>> bubbelEightCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelEightWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelEightWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_EIGHT_MEN));



        //weekly timeslots for bubbel one women
        Map<Week, List<CourtTimeSlot>> bubbelOneWomenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelOneWomenWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelOneWomenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_ONE_WOMEN));



        //weekly timeslots for bubbel one women
        Map<Week, List<CourtTimeSlot>> bubbelTwoWomenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelTwoWomenWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelTwoWomenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_TWO_WOMEN));




        //weekly timeslots for bubbel three women
        Map<Week, List<CourtTimeSlot>> bubbelThreeWomenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelThreeWomenWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelThreeWomenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_THREE_WOMEN));


        //weekly timeslots for bubbel four women
        Map<Week, List<CourtTimeSlot>> bubbelFourWomenCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
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
        reservationService.storeWeekPlanning(bubbelFourWomenWeekPlanningList,false,false);
        //weekPlanningDisplay.displayPlanning(bubbelFourWomenWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_FOUR_WOMEN));







    }




}
