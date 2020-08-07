package padel.service;


import com.realdolmen.padel.model.Court;

import java.util.List;


public interface CourtService {

    void create(Court court);

    void update(Court account);

    void delete(Long id);

    List<Court> getCourts(String language);








}
