package com.realdolmen.padel.rest;

import com.realdolmen.padel.model.Court;
import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.service.CourtService;
import com.realdolmen.padel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RestCourtResource extends BaseResource {


    @Autowired
    private CourtService courtService;

    @RequestMapping(value = "/rest/court", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Court>> getCourts(final HttpServletRequest request) {

        List<Court> courtList = new ArrayList<Court>();
        ResponseEntity<List<Court>> responseEntity = new ResponseEntity<List<Court>>(courtList, HttpStatus.OK);
        try {


            courtList = courtService.getCourts();

            responseEntity = new ResponseEntity(courtList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de padel pleinen" , e);

        }
        return responseEntity;

    }



    @RequestMapping(value = "/rest/court", method = RequestMethod.POST)
    public ResponseEntity<Court> addCourt(final HttpServletRequest request, final @RequestBody Court court) {
        ResponseEntity responseEntity = new ResponseEntity(court, HttpStatus.OK);

        try {
            if (court != null) {
                courtService.create(court);
                responseEntity = new ResponseEntity(court, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de pleinen", e);
        }

        return responseEntity;
    }


    @RequestMapping(value = "/rest/court", method = RequestMethod.PUT)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Member> updateCourt(final @RequestBody Court court) {
        ResponseEntity responseEntity = new ResponseEntity(court, HttpStatus.OK);

        try {
            if (court != null) {
                courtService.update(court);
                responseEntity = new ResponseEntity(court, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van het plein", e);
        }

        return responseEntity;

    }

}
