package com.realdolmen.padel.data;

import com.realdolmen.padel.model.*;

import java.util.List;

//@Component("MysqlDatabaseStore")
public class MysqlDatabaseStore implements DataStore {


    @Override
    public List<Group> getGroups() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Reservation> getReservations() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Member> getPadelMembers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Court> getCourtList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getVtvLevels() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Availability> getAvailabilities() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TimeSlot> getTimeSlots() {
        return null;
    }

    @Override
    public void create(Member member) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Member member) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Member member) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(Group group) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Group group) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Group group) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(Court court) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Court court) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Court court) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(Reservation reservation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Reservation reservation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Reservation reservation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllReservations() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(TimeSlot timeSlot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(TimeSlot timeSlot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(TimeSlot timeSlot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CourtTimeSlot> getCourtTimeSlots() {
        throw new UnsupportedOperationException();
    }
}
