package com.realdolmen.padel.rest;


import com.realdolmen.padel.model.Court;
import com.realdolmen.padel.model.TimeSlot;
import com.realdolmen.padel.model.WeekDay;
import com.realdolmen.padel.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestTimeSlotResource extends BaseResource {


    @Autowired
    private TimeSlotService timeslotService;

    @RequestMapping(value = "/rest/timeslot", method = RequestMethod.GET)
    public ResponseEntity<List<TimeSlot>> getTimeSlots(final HttpServletRequest request) {

        List<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
        ResponseEntity<List<TimeSlot>> responseEntity = new ResponseEntity<List<TimeSlot>>(timeSlotList, HttpStatus.OK);
        try {


            timeSlotList = timeslotService.getTimeSlots();

            responseEntity = new ResponseEntity(timeSlotList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de timeslots", e);

        }
        return responseEntity;

    }


    @RequestMapping(value = "/rest/timeslot/day", method = RequestMethod.GET)
    public ResponseEntity<List<TimeSlot>> getDayTimeSlots(final HttpServletRequest request,final @RequestParam Integer dayOfWeek) {

        List<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
        ResponseEntity<List<TimeSlot>> responseEntity = new ResponseEntity<List<TimeSlot>>(timeSlotList, HttpStatus.OK);
        try {

            timeSlotList = timeslotService.getDayTimeSlots(DayOfWeek.of(dayOfWeek));

            responseEntity = new ResponseEntity(timeSlotList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de timeslots", e);

        }
        return responseEntity;

    }


    @RequestMapping(value = "/rest/timeslot", method = RequestMethod.POST)
    public ResponseEntity<Court> addTimeSlots(final HttpServletRequest request, final @RequestBody TimeSlot timeSlot) {
        ResponseEntity responseEntity = new ResponseEntity(timeSlot, HttpStatus.OK);

        try {
            if (timeSlot != null) {
                timeslotService.create(timeSlot);
                responseEntity = new ResponseEntity(timeSlot, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de timeslots", e);
        }

        return responseEntity;
    }


    @RequestMapping(value = "/rest/timeslot", method = RequestMethod.PUT)
    public ResponseEntity<TimeSlot> updateTimeSlots(final @RequestBody TimeSlot timeSlot) {
        ResponseEntity responseEntity = new ResponseEntity(timeSlot, HttpStatus.OK);

        try {
            if (timeSlot != null) {
                timeslotService.update(timeSlot);
                responseEntity = new ResponseEntity(timeSlot, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van timeslot", e);
        }

        return responseEntity;

    }

}
