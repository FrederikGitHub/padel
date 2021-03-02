package com.realdolmen.padel.service;


import com.realdolmen.padel.model.Court;

import java.util.List;


public interface CourtService {

    Court getCourt(String court);

    void create(Court court);

    void update(Court court);

    void delete(Court court);

    List<Court> getCourts();








}
