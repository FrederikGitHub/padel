package com.realdolmen.padel.rest;

import com.realdolmen.padel.model.*;
import com.realdolmen.padel.service.ReservationRequest;
import com.realdolmen.padel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestReservationResource extends BaseResource {


    @Autowired
    private ReservationService reservationService;



    @RequestMapping(value = "/rest/reservation/week", method = RequestMethod.POST)
    public ResponseEntity<Set<WeekPlanning>> getGroupWeekPlanning(final HttpServletRequest request, final @RequestBody ReservationRequest reservationRequest) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
            Set<WeekPlanning> weekPlannings = reservationService.getGroupWeekPlanning(reservationRequest.getFromDate(),reservationRequest.getToDate(),reservationRequest.getGroup());
            responseEntity = new ResponseEntity(weekPlannings, HttpStatus.OK);

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de reservaties voor de leden", e);
        }

        return responseEntity;
    }


    @RequestMapping(value = "/rest/reservation/membersTotal", method = RequestMethod.POST)
    public ResponseEntity<Map<Member, Long>> getTotalReservationsByMember(final HttpServletRequest request, final @RequestBody ReservationRequest reservationRequest) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
            Map<Member, Long> totalReservationsByMember = reservationService.getTotalReservationsByMember(reservationRequest.getFromDate(),reservationRequest.getToDate());
            responseEntity = new ResponseEntity(totalReservationsByMember, HttpStatus.OK);

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de reservaties voor de leden", e);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/rest/reservation/bye", method = RequestMethod.POST)
    public ResponseEntity<Map<Member, Long>> getTotalByesByMember(final HttpServletRequest request, final @RequestBody ReservationRequest reservationRequest) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
            Map<Member, Long> totalByesByMember = reservationService.getTotalByeByMember(reservationRequest.getFromDate(),reservationRequest.getToDate());
            responseEntity = new ResponseEntity(totalByesByMember, HttpStatus.OK);

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de reservelijst", e);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/rest/reservation", method = RequestMethod.DELETE)
    public ResponseEntity<Map<Court, List<Reservation>>> deleteAllReservations() {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
            reservationService.deleteAllReservations();


        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het verwijderen van de reservaties", e);
        }

        return responseEntity;
    }


    @RequestMapping(value = "/rest/reservation/", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> findAllReservations() {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
            List<Reservation> allReservations = reservationService.findAllReservations();
            responseEntity = new ResponseEntity(allReservations, HttpStatus.OK);

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de reservaties", e);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/rest/reservation/day", method = RequestMethod.POST)
    public ResponseEntity<Map<Court, List<Reservation>>> findDayReservations(final HttpServletRequest request, final @RequestBody ReservationRequest reservationRequest) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
            if (reservationRequest != null) {
                Map<Court, List<Reservation>> dayReservationsByCourt = reservationService.getDayReservations(reservationRequest.getDay());
                responseEntity = new ResponseEntity(dayReservationsByCourt, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de dagreservaties", e);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/rest/reservation", method = RequestMethod.POST)
    public ResponseEntity<Member> addReservation(final HttpServletRequest request, final @RequestBody Reservation reservation) {
        ResponseEntity responseEntity = new ResponseEntity(reservation, HttpStatus.OK);

        try {
            if (reservation != null) {
                reservationService.create(reservation);
                responseEntity = new ResponseEntity(reservation, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de reservatie", e);
        }

        return responseEntity;
    }


    @RequestMapping(value = "/rest/reservation", method = RequestMethod.PUT)
    public ResponseEntity<Reservation> updateReservation(final @RequestBody Reservation reservation) {
        ResponseEntity responseEntity = new ResponseEntity(reservation, HttpStatus.OK);

        try {
            if (reservation != null) {
                reservationService.update(reservation);
                responseEntity = new ResponseEntity(reservation, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de reservatie", e);
        }

        return responseEntity;

    }


    @RequestMapping(value = "/rest/reservation/generateAndValidate", method = RequestMethod.POST)
    public ResponseEntity<Set<WeekPlanning>> generateAndValidatePlanning(final HttpServletRequest request, final @RequestBody PlanningRequest planningRequest) {
        Set<WeekPlanning> weekPlannings = new HashSet<WeekPlanning>();

        ResponseEntity responseEntity = new ResponseEntity(weekPlannings, HttpStatus.OK);

        try {
            if (planningRequest != null) {
                weekPlannings = reservationService.generateWeekPlanning(planningRequest.getFromDate(), planningRequest.getToDate(), planningRequest.getCourtTimeSlotListByWeek(), planningRequest.getMembers(), planningRequest.getGroup());
                reservationService.validateWeekPlanning(weekPlannings, true, true);
                responseEntity = new ResponseEntity(weekPlannings, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opmaken van de planning", e);
        }

        return responseEntity;
    }


}
