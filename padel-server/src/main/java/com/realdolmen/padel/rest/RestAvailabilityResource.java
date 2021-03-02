package com.realdolmen.padel.rest;

import com.realdolmen.padel.model.Availability;
import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.service.AvailabilityService;
import com.realdolmen.padel.service.GroupService;
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
public class RestAvailabilityResource extends BaseResource {


    @Autowired
    private AvailabilityService availabilityService;

    @RequestMapping(value = "/rest/availabilities", method = RequestMethod.GET)
    public ResponseEntity<List<Availability>> getAvailabilities(final HttpServletRequest request) {

        List<Availability> availabilityList = new ArrayList<Availability>();
        ResponseEntity<List<Availability>> responseEntity = new ResponseEntity<List<Availability>>(availabilityList, HttpStatus.OK);
        try {
            availabilityList = availabilityService.getAvailabilities();
            responseEntity = new ResponseEntity(availabilityList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de beschikbaarheden" , e);

        }
        return responseEntity;

    }
}
