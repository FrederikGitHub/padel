package com.realdolmen.padel.model;

import com.realdolmen.padel.entity.MemberEntity;
import com.realdolmen.padel.entity.MemberGroupAvailabilityEntity;
import com.realdolmen.padel.entity.VtvLevelEntity;
import com.realdolmen.padel.entity.WeeklyReserveEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeeklyReserve {
    private long id;
    private Integer weekNr;
    private Integer year;
    private Member member;
    private Group group;
    private Reservation reservation;

    public WeeklyReserve(long id, Integer weekNr, Integer year, Member member, Group group,Reservation reservation) {
        this.id = id;
        this.weekNr = weekNr;
        this.year = year;
        this.member = member;
        this.group = group;
        this.reservation = reservation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getWeekNr() {
        return weekNr;
    }

    public void setWeekNr(Integer weekNr) {
        this.weekNr = weekNr;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public WeeklyReserve setReservation(Reservation reservation) {
        this.reservation = reservation;
        return this;
    }


    public static class Functions {

        public static Function<Member, String> TO_LAST_NAME = new Function<Member, String>() {
            @Override
            public String apply(Member member) {
                return member.getName();
            }
        };


        public static Function<WeeklyReserveEntity, Member> TO_MEMBER = new Function<WeeklyReserveEntity, Member>() {
            @Override
            public Member apply(WeeklyReserveEntity weeklyReserveEntity) {
                Member member = new Member();

                if (weeklyReserveEntity.getMember() != null){
                    member = Member.Functions.FROM_MEMBER_ENTITY.apply(weeklyReserveEntity.getMember());
                }
                return member;

            }
        };



    }
}
