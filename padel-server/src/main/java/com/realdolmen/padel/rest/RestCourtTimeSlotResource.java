package com.realdolmen.padel.rest;

import com.realdolmen.padel.model.CourtTimeSlot;
import com.realdolmen.padel.service.CourtTimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestCourtTimeSlotResource extends BaseResource {


    @Autowired
    private CourtTimeSlotService courtTimeslotService;

    @RequestMapping(value = "/rest/courtTimeSlot", method = RequestMethod.GET)
    public ResponseEntity<List<CourtTimeSlot>> getTimeSlots(final HttpServletRequest request) {

        List<CourtTimeSlot> courtTimeSlotList = new ArrayList<CourtTimeSlot>();
        ResponseEntity<List<CourtTimeSlot>> responseEntity = new ResponseEntity<List<CourtTimeSlot>>(courtTimeSlotList, HttpStatus.OK);
        try {


            courtTimeSlotList = courtTimeslotService.getCourtTimeSlots();

            responseEntity = new ResponseEntity(courtTimeSlotList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de court timeslots", e);

        }
        return responseEntity;

    }



}
