package com.realdolmen.padel.rest;

import com.realdolmen.padel.model.Group;
import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.service.GroupService;
import com.realdolmen.padel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RestGroupResource extends BaseResource {


    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/rest/group", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Group>> getGroups(final HttpServletRequest request) {

        List<Group> groupList = new ArrayList<Group>();
        ResponseEntity<List<Group>> responseEntity = new ResponseEntity<List<Group>>(groupList, HttpStatus.OK);
        try {


            groupList = groupService.getGroups();

            responseEntity = new ResponseEntity(groupList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de padel groepen" , e);

        }
        return responseEntity;

    }



    @RequestMapping(value = "/rest/group", method = RequestMethod.POST)
    public ResponseEntity<Member> addGroepr(final HttpServletRequest request, final @RequestBody Group group) {
        ResponseEntity responseEntity = new ResponseEntity(group, HttpStatus.OK);

        try {
            if (group != null) {
                groupService.create(group);
                responseEntity = new ResponseEntity(group, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de groepgegevens", e);
        }

        return responseEntity;
    }


    @RequestMapping(value = "/rest/group", method = RequestMethod.PUT)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Member> updateGroup(final @RequestBody Group group) {
        ResponseEntity responseEntity = new ResponseEntity(group, HttpStatus.OK);

        try {
            if (group != null) {
                groupService.update(group);
                responseEntity = new ResponseEntity(group, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de groepgegevens", e);
        }

        return responseEntity;

    }

}
