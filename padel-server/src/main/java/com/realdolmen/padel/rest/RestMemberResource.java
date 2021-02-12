package com.realdolmen.padel.rest;

import com.realdolmen.padel.model.Member;
import com.realdolmen.padel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RestMemberResource extends BaseResource {


    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/rest/member", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Member>> getMembersByGroup(final HttpServletRequest request, final @RequestParam(value = "groupAvailability") String groupAvailability) {

        List<Member> memberList = new ArrayList<Member>();
        ResponseEntity<List<Member>> responseEntity = new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
        try {


            memberList = memberService.getMembersForGroupAvailability(groupAvailability);

            responseEntity = new ResponseEntity(memberList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de padel leden" , e);

        }
        return responseEntity;

    }

    @RequestMapping(value = "/rest/member", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Member>> getAllMembers() {

        List<Member> memberList = new ArrayList<Member>();
        ResponseEntity<List<Member>> responseEntity = new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
        try {


            memberList = memberService.getPadelMembers();

            responseEntity = new ResponseEntity(memberList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de padel leden" , e);

        }
        return responseEntity;

    }

    @RequestMapping(value = "/rest/member", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Member>> getMembersByLevel(final HttpServletRequest request, final @RequestParam(value = "level") String level) {

        List<Member> memberList = new ArrayList<Member>();
        ResponseEntity<List<Member>> responseEntity = new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
        try {


            memberList = memberService.getMembersForLevel(level);

            responseEntity = new ResponseEntity(memberList, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het ophalen van de padel leden" , e);

        }
        return responseEntity;

    }



    @RequestMapping(value = "/rest/member", method = RequestMethod.POST)
    public ResponseEntity<Member> addMember(final HttpServletRequest request, final @RequestBody Member member) {
        ResponseEntity responseEntity = new ResponseEntity(member, HttpStatus.OK);

        try {
            if (member != null) {
                memberService.create(member);
                responseEntity = new ResponseEntity(member, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de lidgegevens", e);
        }

        return responseEntity;
    }


    @RequestMapping(value = "/rest/member", method = RequestMethod.PUT)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Member> updatMember(final @RequestBody Member member) {
        ResponseEntity responseEntity = new ResponseEntity(member, HttpStatus.OK);

        try {
            if (member != null) {
                memberService.update(member);
                responseEntity = new ResponseEntity(member, HttpStatus.OK);
            }

        } catch (Exception e) {
            responseEntity = handleException("Er is een fout opgetreden bij het opslaan van de lidgegevens", e);
        }

        return responseEntity;

    }

}
