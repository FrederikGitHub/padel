package com.realdolmen.padel.rest;

import com.realdolmen.padel.model.AutoReservationRequest;
import com.realdolmen.padel.model.PlanningRequest;
import com.realdolmen.padel.model.WeekPlanning;
import com.realdolmen.padel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestPlanningResource extends BaseResource {


    @Autowired
    private ReservationService reservationService;




    @RequestMapping(value = "/rest/planning/generateAndValidate", method = RequestMethod.POST)
    public ResponseEntity<Set<WeekPlanning>> generateAndValidatePlanning(final HttpServletRequest request, final @RequestBody AutoReservationRequest planningRequest) {
        Set<WeekPlanning> weekPlannings = new HashSet<WeekPlanning>();

        ResponseEntity responseEntity = new ResponseEntity(weekPlannings, HttpStatus.OK);

        /*try {
            if (planningRequest != null) {
                weekPlannings = reservationService.restGenerateWeekPlanning(planningRequest.getFromDate(),planningRequest.getToDate(),planningRequest.getCourtTimeSlotWeekList(),planningRequest.getMembers(),planningRequest.getGroup(),false);
                reservationService.validateWeekPlanning(weekPlannings,true,true);
                responseEntity = new ResponseEntity(weekPlannings, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opmaken van de planning", e);
        }*/

        return responseEntity;
    }

    @RequestMapping(value = "/rest/planning/store", method = RequestMethod.POST)
    public ResponseEntity storePlanning(final HttpServletRequest request, final @RequestBody Set<WeekPlanning> weekPlannings) {

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {

            reservationService.storeWeekPlanning(weekPlannings,false,false);
            responseEntity = new ResponseEntity(HttpStatus.OK);


        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de planning", e);
        }

        return responseEntity;
    }




}
