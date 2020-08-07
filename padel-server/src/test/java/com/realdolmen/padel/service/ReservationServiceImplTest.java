package com.realdolmen.padel.service;

import com.realdolmen.padel.model.*;
import com.realdolmen.padel.model.builder.MemberBuilder;
import com.realdolmen.padel.model.builder.TimeSlotBuilder;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
public class ReservationServiceImplTest {

    @Autowired
    private ReservationService reservationService;


    @MockBean
    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        List<Member> loverMembers = new ArrayList<Member>();
        Member frederik = new MemberBuilder().setId(1L).setFirstName("Frederik").setName("Van Heddeghem").build();
        loverMembers.add(frederik);
        Member dirk = new MemberBuilder().setId(2L).setFirstName("Dirk").setName("Demil").build();
        loverMembers.add(dirk);
        Member kris = new MemberBuilder().setId(3L).setFirstName("Kris").setName("Dhose").build();
        loverMembers.add(kris);
        Member kristof = new MemberBuilder().setId(4L).setFirstName("Kristof").setName("Verplanken").build();
        loverMembers.add(kristof);
        Member pedro = new MemberBuilder().setId(5L).setFirstName("Pedro").setName("Leroy").build();
        loverMembers.add(pedro);
        Member philip = new MemberBuilder().setId(6L).setFirstName("Philip").setName("Cappeleman").build();
        loverMembers.add(philip);
        Member tim = new MemberBuilder().setId(7L).setFirstName("Tim").setName("Van Wymeersch").build();
        loverMembers.add(tim);
        Member krisVanHee = new MemberBuilder().setId(8L).setFirstName("Kris").setName("Vanhee").build();
        loverMembers.add(krisVanHee);
        Member werner = new MemberBuilder().setId(9L).setFirstName("Werner").setName("Goossens").build();
        loverMembers.add(werner);
        Member tom = new MemberBuilder().setId(10L).setFirstName("Tom").setName("Van de Velde").build();
        loverMembers.add(tom);
        Member davy = new MemberBuilder().setId(11L).setFirstName("Davy").setName("Verstichelen").build();
        loverMembers.add(davy);
        Member bart = new MemberBuilder().setId(12L).setFirstName("Bart").setName("Stalpaert").build();
        loverMembers.add(bart);
        Member bruno = new MemberBuilder().setId(13L).setFirstName("Bruno").setName("Torrekens").build();
        loverMembers.add(bruno);
        Member wendy = new MemberBuilder().setId(14L).setFirstName("Wendy").setName("Leroy").build();
        loverMembers.add(wendy);
        Member dominik = new MemberBuilder().setId(15L).setFirstName("Dominik").setName("De Smedt").build();
        loverMembers.add(dominik);
        Mockito.when(memberService.getMembersForGroup(Mockito.anyLong()))
                .thenReturn(loverMembers);
    }

    @Test
    public void generateWeekPlanningTest(){
        LocalDate startDate = LocalDate.of(2021,1,1);
        LocalDate endDate = LocalDate.of(2021,12,31);
        Group lovers = new Group(1L,"Lovers");
        List<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
        TimeSlot mondayAt1830 = new TimeSlotBuilder().setId(1L).setWeekday(new WeekDay(1L,1L,"MAANDAG")).setCourt(new Court(1L,"court 1")).setFrom("18:30").setTo("20:00").build();
        timeSlotList.add(mondayAt1830);
        TimeSlot thursdayAt1830OnCourt1 = new TimeSlotBuilder().setId(2L).setWeekday(new WeekDay(2L,4L,"DONDERDAG")).setCourt(new Court(1L,"court 1")).setFrom("18:30").setTo("20:00").build();
        timeSlotList.add(thursdayAt1830OnCourt1);
        TimeSlot thursdayAt1830OnCourt2 = new TimeSlotBuilder().setId(3L).setWeekday(new WeekDay(3L,4L,"DONDERDAG")).setCourt(new Court(2L,"court 2")).setFrom("18:30").setTo("20:00").build();
        timeSlotList.add(thursdayAt1830OnCourt2);
        List<WeekPlanning> weekPlanningList = reservationService.generateWeekPlanning(startDate,endDate,timeSlotList,lovers);
        System.out.println(weekPlanningList);

    }

    @TestConfiguration
    static class ReservationServiceImplTestContextConfiguration {

        @Bean
        public ReservationService employeeService() {
            return new ReservationServiceImpl();
        }
    }


}
