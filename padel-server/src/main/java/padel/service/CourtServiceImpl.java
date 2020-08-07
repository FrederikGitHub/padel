package padel.service;

import com.realdolmen.padel.model.Court;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CourtServiceImpl implements CourtService {


    @Override
    @Transactional
    public void create(Court court) {

    }

    @Override
    @Transactional
    public void update(Court account) {

    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public List<Court> getCourts(String language) {
        return null;
    }
}




