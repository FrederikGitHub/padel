package com.realdolmen.padel.service;

import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.model.Reservation;
import com.realdolmen.padel.model.WeekPlanning;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Set;

public class WeekPlanningDisplay {
    public void displayPlanning(Set<WeekPlanning> weekPlanningList, Group group){
        StringBuffer buffer = new StringBuffer("");
        Locale dutchLocale=new Locale("nl", "BE");
        for (WeekPlanning weekPlanning:weekPlanningList){

            //buffer.append("Week " + weekPlanning.getWeek().getWeekOfYear() + " van het jaar,week " + weekPlanning.getWeek().getWeekOfMonth() + " van de maand "  + " planning: van " + weekPlanning.getWeek().getStartWeekDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " tot " + weekPlanning.getWeek().getEndWeekDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            buffer.append("planning voor group " + group.getName() + " vanaf " + weekPlanning.getWeek().getStartWeekDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " tot " + weekPlanning.getWeek().getEndWeekDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ",weekjaar " + weekPlanning.getWeek().getWeekOfYear() + ",weekmaand " + weekPlanning.getWeek().getWeekOfMonth());

            buffer.append("\n");
            int reservationIndex = 1;
            buffer.append("Reservaties: ");
            buffer.append("\n");
            for (Reservation reservation:weekPlanning.getReservationList()){
                LocalDate reservationDate = LocalDate.of(reservation.getYear(),reservation.getMonth(),reservation.getDay());;
                String formattedReservationDate=reservationDate.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",dutchLocale));
                buffer.append(reservationIndex + ": " + formattedReservationDate + " vanaf " + reservation.getCourtTimeSlot().getTimeSlot().getFrom() + " tot "+ reservation.getCourtTimeSlot().getTimeSlot().getTo() + " op terrein " + reservation.getCourtTimeSlot().getCourt().getName() + ":");
                //buffer.append(reservationIndex + ": " + reservation.getDay() + "/" + reservation.getMonth() + "/" + reservation.getYear() + " " + reservation.getCourtTimeSlot().getTimeSlot().getFrom() + " tot "+ reservation.getCourtTimeSlot().getTimeSlot().getTo() + " terrein " + reservation.getCourtTimeSlot().getCourt().getName() + ":");
                for (Member member:reservation.getReservationMembers()){
                    buffer.append(member.getFirstName() + " " + member.getName() + ",");
                }
                buffer.append("\n");
                reservationIndex++;
            }
            buffer.append("\n");
            buffer.append("Reserves: ");
            buffer.append("\n");
            int reserveIndex = 1;
            for (Member member:weekPlanning.getReserveList()){
                buffer.append(reserveIndex + ": " + member.getName() + " " + member.getFirstName() + ",");
                buffer.append("\n");
                reserveIndex++;
            }
            buffer.append("\n");
        }
        System.out.println(buffer.toString());

    }
}
