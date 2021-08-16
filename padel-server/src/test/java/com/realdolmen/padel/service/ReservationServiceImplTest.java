package com.realdolmen.padel.service;

import com.realdolmen.padel.assertions.WeekPlanningAssert;
import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.data.InMemoryDataStore;
import com.realdolmen.padel.exception.PadelRuntimeException;
import com.realdolmen.padel.model.*;
import com.realdolmen.padel.model.builder.CourtTimeSlotBuilder;
import com.realdolmen.padel.model.builder.WeekBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
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
import java.util.stream.Collectors;


@ExtendWith(SpringExtension.class)
@Ignore
public class ReservationServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImplTest.class);

    @Autowired
    private ReservationService reservationService;

    private List<Member> p500MenMembers;
    private List<Member> p300MenMembers;
    private List<Member> p200MenMembers;
    private List<Member> dummyMembers;

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
        p500MenMembers = memberService.getMembersForGroupAvailability(dataStore.P500_MEN);
        p300MenMembers = memberService.getMembersForGroupAvailability(dataStore.P300_MEN);
        p200MenMembers = memberService.getMembersForGroupAvailability(dataStore.P200_MEN);
        dummyMembers = memberService.getMembersForGroupAvailability(dataStore.DUMMY_GROUP);

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


        //correct plan period
        startDate = LocalDate.of(2021, Month.MARCH, 29);
        endDate = LocalDate.of(2021, Month.JULY, 1);

    }


    //@Test
    @Ignore
    public void generateWeekPlanningTest() {

        //weekly timeslots by group
        List<CourtTimeSlot> p500CourtTimeSlotList = new ArrayList<CourtTimeSlot>();
        List<CourtTimeSlot> p300CourtTimeSlotList = new ArrayList<CourtTimeSlot>();
        List<CourtTimeSlot> p200and300FirstWeekCourtTimeSlotList = new ArrayList<CourtTimeSlot>();
        List<CourtTimeSlot> p200CourtTimeSlotList = new ArrayList<CourtTimeSlot>();

        //p500 needs 2 timeslots each week at thursday
        p500CourtTimeSlotList.add(thursdayAt1830OnCourt1);
        p500CourtTimeSlotList.add(thursdayAt1830OnCourt2);

        //p300 needs the first week of the month 8 timeslots on monday and on thursday 3 timeslots
        p200and300FirstWeekCourtTimeSlotList.add(thursdayAt2000OnCourt1);
        p200and300FirstWeekCourtTimeSlotList.add(thursdayAt2000OnCourt2);
        p200and300FirstWeekCourtTimeSlotList.add(thursdayAt2130OnCourt1);
        p200and300FirstWeekCourtTimeSlotList.add(thursdayAt2130OnCourt2);
        p200and300FirstWeekCourtTimeSlotList.add(mondayAt1830OnCourt1);
        p200and300FirstWeekCourtTimeSlotList.add(mondayAt1830OnCourt2);
        p200and300FirstWeekCourtTimeSlotList.add(mondayAt2000OnCourt1);
        p200and300FirstWeekCourtTimeSlotList.add(mondayAt2000OnCourt2);

        //p300 needs 3 timeslots each week at thursday except first week
        p300CourtTimeSlotList.add(thursdayAt2000OnCourt1);
        p300CourtTimeSlotList.add(thursdayAt2000OnCourt2);
        p300CourtTimeSlotList.add(thursdayAt2130OnCourt1);

        //p200 needs 5 timeslots each week on monday and thursday except for the first week
        p200CourtTimeSlotList.add(thursdayAt2130OnCourt2);
        p200CourtTimeSlotList.add(mondayAt1830OnCourt1);
        p200CourtTimeSlotList.add(mondayAt1830OnCourt2);
        p200CourtTimeSlotList.add(mondayAt2000OnCourt1);
        p200CourtTimeSlotList.add(mondayAt2000OnCourt2);
        p200CourtTimeSlotList.add(mondayAt2130OnCourt1);
        p200CourtTimeSlotList.add(mondayAt2130OnCourt2);


        //p500courtTimeSlotListByWeek
        Map<Week, List<CourtTimeSlot>> p500courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), p500CourtTimeSlotList);


        //p300courtTimeSlotListByWeek
        Map<Week, List<CourtTimeSlot>> p300courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), p200and300FirstWeekCourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), p200and300FirstWeekCourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), p200and300FirstWeekCourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), p200and300FirstWeekCourtTimeSlotList);

        //p200courtTimeSlotListByWeek
        Map<Week, List<CourtTimeSlot>> p200courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), p200and300FirstWeekCourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), p200and300FirstWeekCourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), p200and300FirstWeekCourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), p200CourtTimeSlotList);
        p200courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), p200and300FirstWeekCourtTimeSlotList);

        WeekPlanningDisplay weekPlanningDisplay = new WeekPlanningDisplay();

        //generate weekplanning for p500
        Set<WeekPlanning> p500WeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, p500courtTimeSlotListByWeek, p500MenMembers, groupService.getGroup(dataStore.P500_MEN),true);
        weekPlanningDisplay.displayPlanning(p500WeekPlanningList,groupService.getGroup(dataStore.P500_MEN));

        //generate weekplanning for p300
        Set<WeekPlanning> p300WeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, p300courtTimeSlotListByWeek, p300MenMembers, groupService.getGroup(dataStore.P300_MEN),true);
        weekPlanningDisplay.displayPlanning(p300WeekPlanningList,groupService.getGroup(dataStore.P300_MEN));

        //generate weekplanning for p200
        Set<WeekPlanning> p200WeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, p200courtTimeSlotListByWeek, p200MenMembers, groupService.getGroup(dataStore.P200_MEN),true);
        weekPlanningDisplay.displayPlanning(p200WeekPlanningList,groupService.getGroup(dataStore.P200_MEN));

        Assertions.assertThat(p300WeekPlanningList.size()).describedAs("No weekPlannings").isGreaterThan(0);


        Member DiegoVanHuffel = memberService.getPadelMembers().stream().filter(Member.Predicates.startWithName("Van Huffel")).findFirst().get();
        long totalReservationsForDiegoVanHuffel = p500WeekPlanningList.stream().flatMap(WeekPlanning.Functions.TO_RESERVATIONS).flatMap(Reservation.Functions.TO_MEMBERS).collect(Collectors.toList()).stream().filter(Member.Predicates.startWithName(DiegoVanHuffel.getName())).count();

        Assertions.assertThat(totalReservationsForDiegoVanHuffel).describedAs("No correct total reservations for diego").isGreaterThan(2);

        p500WeekPlanningList.stream().forEach(weekPlanning -> WeekPlanningAssert.assertThat(weekPlanning).hasAtLeastReservationCount(1));


    }

    //@Test
    @Ignore
    public void generateWeekPlanningForNotEnoughTimeslotsTest() {

        List<CourtTimeSlot> courtTimeSlotList = new ArrayList<CourtTimeSlot>();

        courtTimeSlotList.add(thursdayAt1830OnCourt1);

        Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), courtTimeSlotList);

        try {
            Set<WeekPlanning> weekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, courtTimeSlotListByWeek, p500MenMembers, groupService.getGroup(dataStore.P500_MEN),true);
            Assertions.fail("Padel runtime exception with message code 'NOT_ENOUGH_TIMESLOTS' should be thrown");
        } catch (PadelRuntimeException padelRuntimeException) {
            logger.info(padelRuntimeException.getLocalizedMessage());
        }
    }

    //@Test
    @Ignore
    public void generateWeekPlanningForIncorrectPeriodTest() {
        List<CourtTimeSlot> courtTimeSlotList = new ArrayList<CourtTimeSlot>();

        courtTimeSlotList.add(thursdayAt1830OnCourt1);

        Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), courtTimeSlotList);

        try {
            Set<WeekPlanning> weekPlanningList = reservationService.generateWeekPlanning(endDate, startDate, courtTimeSlotListByWeek, p500MenMembers, groupService.getGroup(dataStore.P500_MEN),true);
            Assertions.fail("Padel runtime exception with message code 'NO_CORRECT_PLANNING_PERIOD' should be thrown");
        } catch (PadelRuntimeException padelRuntimeException) {
            logger.info(padelRuntimeException.getLocalizedMessage());
        }
    }


    //@Test
    @Ignore
    public void generateWeekPlanningWithNotEnoughMembersTest() {

        List<CourtTimeSlot> courtTimeSlotList = new ArrayList<CourtTimeSlot>();

        courtTimeSlotList.add(thursdayAt1830OnCourt1);

        Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), courtTimeSlotList);

        try {
            Set<WeekPlanning> weekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, courtTimeSlotListByWeek, dummyMembers, groupService.getGroup(dataStore.DUMMY_GROUP),true);
            Assertions.fail("Padel runtime exception with message code 'NOT_ENOUGH_MEMBERS_TO_MAKE_PLANNING' should be thrown");
        } catch (PadelRuntimeException padelRuntimeException) {
            logger.info(padelRuntimeException.getLocalizedMessage());
        }
    }

    //@Test
    @Ignore
    public void generateAndStoreWeekPlanningTest() {
        //weekly timeslots by group
        List<CourtTimeSlot> p500CourtTimeSlotList = new ArrayList<CourtTimeSlot>();
        List<CourtTimeSlot> p300CourtTimeSlotList = new ArrayList<CourtTimeSlot>();
        List<CourtTimeSlot> p200and300FirstWeekCourtTimeSlotList = new ArrayList<CourtTimeSlot>();
        List<CourtTimeSlot> p200CourtTimeSlotList = new ArrayList<CourtTimeSlot>();

        //p500 needs 2 timeslots each week at thursday
        p500CourtTimeSlotList.add(thursdayAt1830OnCourt1);
        p500CourtTimeSlotList.add(thursdayAt1830OnCourt2);

        //p300 needs the first week of the month 8 timeslots on monday and thursday
        p200and300FirstWeekCourtTimeSlotList.add(thursdayAt2000OnCourt1);
        p200and300FirstWeekCourtTimeSlotList.add(thursdayAt2000OnCourt2);
        p200and300FirstWeekCourtTimeSlotList.add(thursdayAt2130OnCourt1);
        p200and300FirstWeekCourtTimeSlotList.add(thursdayAt2130OnCourt2);
        p200and300FirstWeekCourtTimeSlotList.add(mondayAt1830OnCourt1);
        p200and300FirstWeekCourtTimeSlotList.add(mondayAt1830OnCourt2);
        p200and300FirstWeekCourtTimeSlotList.add(mondayAt2000OnCourt1);
        p200and300FirstWeekCourtTimeSlotList.add(mondayAt2000OnCourt2);

        //p300 needs 3 timeslots each week at thursday except first week
        p300CourtTimeSlotList.add(thursdayAt2000OnCourt1);
        p300CourtTimeSlotList.add(thursdayAt2000OnCourt2);
        p300CourtTimeSlotList.add(thursdayAt2130OnCourt1);

        //p200 needs 5 timeslots each week on monday and thursday except for the first week
        p200CourtTimeSlotList.add(thursdayAt2130OnCourt2);
        p200CourtTimeSlotList.add(mondayAt1830OnCourt1);
        p200CourtTimeSlotList.add(mondayAt1830OnCourt2);
        p200CourtTimeSlotList.add(mondayAt2000OnCourt1);
        p200CourtTimeSlotList.add(mondayAt2000OnCourt2);
        p200CourtTimeSlotList.add(mondayAt2130OnCourt1);
        p200CourtTimeSlotList.add(mondayAt2130OnCourt2);


        //p500courtTimeSlotListByWeek
        Map<Week, List<CourtTimeSlot>> p500courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), p500CourtTimeSlotList);
        p500courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), p500CourtTimeSlotList);


        //p300courtTimeSlotListByWeek
        Map<Week, List<CourtTimeSlot>> p300courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), p200and300FirstWeekCourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), p200and300FirstWeekCourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), p200and300FirstWeekCourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), p300CourtTimeSlotList);
        p300courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), p200and300FirstWeekCourtTimeSlotList);

        WeekPlanningDisplay weekPlanningDisplay = new WeekPlanningDisplay();

        //generate weekplanning for p500
        Set<WeekPlanning> p500WeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, p500courtTimeSlotListByWeek, p500MenMembers, groupService.getGroup(dataStore.P500_MEN),true);
        weekPlanningDisplay.displayPlanning(p500WeekPlanningList,groupService.getGroup(dataStore.P500_MEN));

        //generate weekplanning for p300
        Set<WeekPlanning> p300WeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, p300courtTimeSlotListByWeek, p300MenMembers, groupService.getGroup(dataStore.P300_MEN),true);
        weekPlanningDisplay.displayPlanning(p300WeekPlanningList,groupService.getGroup(dataStore.P300_MEN));

        reservationService.storeWeekPlanning(p500WeekPlanningList, false, false);
        reservationService.storeWeekPlanning(p300WeekPlanningList, false, false);

        List<Reservation> allReservations = reservationService.findAllReservations();

        logger.debug("size allReservations" + allReservations.size());

        Set<WeekPlanning> p500StoredGroupPlanning = reservationService.getGroupWeekPlanning(startDate,endDate,groupService.getGroup(dataStore.P500_MEN));
        logger.debug("total stored week reservation" + p500StoredGroupPlanning.size());
        weekPlanningDisplay.displayPlanning(p500StoredGroupPlanning,groupService.getGroup(dataStore.P500_MEN));

        Set<WeekPlanning> p300StoredGroupPlanning = reservationService.getGroupWeekPlanning(startDate,endDate,groupService.getGroup(dataStore.P500_MEN));
        logger.debug("total stored week reservation" + p300StoredGroupPlanning.size());
        weekPlanningDisplay.displayPlanning(p300StoredGroupPlanning,groupService.getGroup(dataStore.P500_MEN));

        Map<Member,Long> totalReservationsByMember = reservationService.getTotalReservationsByMember(startDate,endDate);
        for (Map.Entry<Member, Long> entry : totalReservationsByMember.entrySet()) {
            logger.debug(entry.getKey().getName() + " " + entry.getKey().getFirstName() + "=" + entry.getValue());
        }
        logger.debug("totalReservationsByMember" + totalReservationsByMember);

        List<Reservation> dayReservations = reservationService.getDayReservations(LocalDate.of(2021,Month.APRIL,1));
        
        logger.debug("dayReservations" + dayReservations);


    }

    //@Test
    @Ignore
    public void generateAndStoreWeekPlanningWithTimeSlotOverBookingTest() {
        List<CourtTimeSlot> courtTimeSlotList = new ArrayList<CourtTimeSlot>();

        courtTimeSlotList.add(thursdayAt1830OnCourt1);
        courtTimeSlotList.add(thursdayAt1830OnCourt2);


        courtTimeSlotList.add(thursdayAt2000OnCourt1);
        courtTimeSlotList.add(thursdayAt2000OnCourt2);

        Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), courtTimeSlotList);

        Set<WeekPlanning> weekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, courtTimeSlotListByWeek, p500MenMembers, groupService.getGroup(dataStore.P500_MEN),true);

        WeekPlanningDisplay weekPlanningDisplay = new WeekPlanningDisplay();
        weekPlanningDisplay.displayPlanning(weekPlanningList,groupService.getGroup(dataStore.P500_MEN));

        reservationService.storeWeekPlanning(weekPlanningList, false, false);

        try {
            reservationService.storeWeekPlanning(weekPlanningList, true, false);
            Assertions.fail("Padel runtime exception with message code 'COURT_OVERBOOKED' should be thrown");
        } catch (PadelRuntimeException padelRuntimeException) {
            logger.info(padelRuntimeException.getLocalizedMessage());
        }



    }

    //@Test
    @Ignore
    public void generateAndStoreWeekPlanningWithMemberOverBookingTest() {

        List<CourtTimeSlot> courtTimeSlotList = new ArrayList<CourtTimeSlot>();

        courtTimeSlotList.add(thursdayAt1830OnCourt1);
        courtTimeSlotList.add(thursdayAt1830OnCourt2);

        courtTimeSlotList.add(thursdayAt2000OnCourt1);
        courtTimeSlotList.add(thursdayAt2000OnCourt2);

        Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), courtTimeSlotList);

        Set<WeekPlanning> weekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, courtTimeSlotListByWeek, p500MenMembers, groupService.getGroup(dataStore.P500_MEN),true);

        WeekPlanningDisplay weekPlanningDisplay = new WeekPlanningDisplay();
        weekPlanningDisplay.displayPlanning(weekPlanningList,groupService.getGroup(dataStore.P500_MEN));

        reservationService.storeWeekPlanning(weekPlanningList, false, false);

        try {
            reservationService.storeWeekPlanning(weekPlanningList, false, true);

            Assertions.fail("Padel runtime exception with message code 'TOO_MANY_RESERVATIONS' should be thrown");
        } catch (PadelRuntimeException padelRuntimeException) {
            logger.info(padelRuntimeException.getLocalizedMessage());
        }



    }

    //@Test
    @Ignore
    public void generateAndStoreWeekPlanningTwiceTest() {
        List<CourtTimeSlot> courtTimeSlotList = new ArrayList<CourtTimeSlot>();


        courtTimeSlotList.add(thursdayAt1830OnCourt1);
        courtTimeSlotList.add(thursdayAt1830OnCourt2);

        courtTimeSlotList.add(thursdayAt2000OnCourt1);
        courtTimeSlotList.add(thursdayAt2000OnCourt2);

        Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), courtTimeSlotList);
        courtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), courtTimeSlotList);

        Set<WeekPlanning> weekPlanningList1 = reservationService.generateWeekPlanning(startDate, endDate, courtTimeSlotListByWeek, p500MenMembers, groupService.getGroup(dataStore.P500_MEN),true);

        WeekPlanningDisplay weekPlanningDisplay = new WeekPlanningDisplay();
        weekPlanningDisplay.displayPlanning(weekPlanningList1,groupService.getGroup(dataStore.P500_MEN));

        reservationService.storeWeekPlanning(weekPlanningList1, false, false);

        logger.debug(""+ dataStore.getReservations().size());
        logger.debug(""+ dataStore.getReservations().toString());

        Set<WeekPlanning> weekPlanningList2 = reservationService.generateWeekPlanning(startDate, endDate, courtTimeSlotListByWeek, p500MenMembers, groupService.getGroup(dataStore.P500_MEN),true);
        weekPlanningDisplay.displayPlanning(weekPlanningList2,groupService.getGroup(dataStore.P500_MEN));

        reservationService.storeWeekPlanning(weekPlanningList2, false, false);




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
            return new MemberServiceImpl();
        }


//        @Bean("InMemoryCourtService")
        @Bean
        public CourtService courtService() {
            return new CourtServiceImpl();
        }

        @Bean
        public GroupService groupService() {
            return new GroupServiceImpl();
        }




        @Bean
        public DataStore dataSource() {
            return new InMemoryDataStore();
        }


    }



}
