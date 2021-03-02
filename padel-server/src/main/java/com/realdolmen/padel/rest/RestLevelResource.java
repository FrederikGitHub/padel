package com.realdolmen.padel.rest;

import com.realdolmen.padel.service.LevelService;
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
public class RestLevelResource extends BaseResource {

    @Autowired
    private LevelService levelService;

    @RequestMapping(value = "/rest/level", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getLevels(final HttpServletRequest request) {

        List<String> levels = new ArrayList<String>();
        ResponseEntity<List<String>> responseEntity = new ResponseEntity<List<String>>(levels, HttpStatus.OK);
        try {
            levels = levelService.getLevels();
            responseEntity = new ResponseEntity(levels, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de vtv levels", e);

        }
        return responseEntity;

    }

}
