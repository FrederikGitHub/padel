package com.realdolmen.padel.service;

import com.realdolmen.padel.assertions.WeekPlanningAssert;
import com.realdolmen.padel.data.BubbelsInMemoryDataStore;
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
public class BubbelsReservationServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(BubbelsReservationServiceImplTest.class);

    @Autowired
    private ReservationService reservationService;

    private List<Member> bubbelOneMembers;
    private List<Member> bubbelTwoMembers;
    private List<Member> bubbelThreeMembers;
    private List<Member> bubbelFourMembers;
    private List<Member> bubbelFiveMembers;
    private List<Member> bubbelSixMembers;
    private List<Member> bubbelSevenMembers;
    private List<Member> bubbelEightmembers;

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
        bubbelOneMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_ONE);
        bubbelTwoMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_TWO);
        bubbelThreeMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_THREE);
        bubbelFourMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_FOUR);
        bubbelFiveMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_FIVE);
        bubbelSixMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_SIX);
        bubbelSevenMembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_SEVEN);
        bubbelEightmembers = memberService.getMembersForGroupAvailability(dataStore.BUBBEL_EIGHT);


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


    @Test
    public void generateWeekPlanningBubbelsTest() {

        WeekPlanningDisplay weekPlanningDisplay = new WeekPlanningDisplay();

        //weekly timeslots for bubbel one
        Map<Week, List<CourtTimeSlot>> bubbelOneCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));

        //generate weekplanning for bubbel one
        Set<WeekPlanning> bubbelOneWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelOneCourtTimeSlotListByWeek, bubbelOneMembers, groupService.getGroup(dataStore.BUBBEL_ONE),true);
        weekPlanningDisplay.displayPlanning(bubbelOneWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_ONE));


        /*Map<Week, List<CourtTimeSlot>> bubbelTwoCourtTimeSlotListByWeek = new HashMap<Week, List<CourtTimeSlot>>();
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(14).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MARCH, 29)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 4)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(15).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 5)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 11)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(16).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 12)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 18)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(17).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 19)).setEndWeekDay(LocalDate.of(2021, Month.APRIL, 25)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(18).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.APRIL, 26)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 2)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(19).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 3)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 9)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(20).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 10)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 16)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(21).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 17)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 23)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(22).setWeekOfMonth(5).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 24)).setEndWeekDay(LocalDate.of(2021, Month.MAY, 30)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(23).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.MAY, 31)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 6)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(24).setWeekOfMonth(2).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 7)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 13)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(25).setWeekOfMonth(3).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 14)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 20)).build(), Arrays.asList(thursdayAt2130OnCourt1,thursdayAt2130OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(26).setWeekOfMonth(4).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 21)).setEndWeekDay(LocalDate.of(2021, Month.JUNE, 27)).build(), Arrays.asList(thursdayAt1830OnCourt1,thursdayAt1830OnCourt2));
        bubbelOneCourtTimeSlotListByWeek.put(new WeekBuilder().setWeekOfYear(27).setWeekOfMonth(1).setYear(2021).setStartWeekDay(LocalDate.of(2021, Month.JUNE, 28)).setEndWeekDay(LocalDate.of(2021, Month.JULY, 4)).build(), Arrays.asList(thursdayAt2000OnCourt1,thursdayAt2000OnCourt2));

        //generate weekplanning for bubbel one
        Set<WeekPlanning> bubbelTwoWeekPlanningList = reservationService.generateWeekPlanning(startDate, endDate, bubbelTwoCourtTimeSlotListByWeek, bubbelTwoMembers, groupService.getGroup(dataStore.BUBBEL_TWO));
        weekPlanningDisplay.displayPlanning(bubbelTwoWeekPlanningList,groupService.getGroup(dataStore.BUBBEL_TWO));*/

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
