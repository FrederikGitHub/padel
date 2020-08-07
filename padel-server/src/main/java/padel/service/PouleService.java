package padel.service;

import com.realdolmen.padel.model.PouleTourGame;

import java.util.Date;

public interface PouleService {
    public void closePouleTour();

    public void openPouleTour(Date fromDate, Date toDate);

    void create(PouleTourGame pouleTourGame);

    void update(PouleTourGame pouleTourGame);

    void dalete(PouleTourGame pouleTourGame);
}
