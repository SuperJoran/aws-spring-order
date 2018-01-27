package be.superjoran.services;

import be.superjoran.dao.ChosenOptionDao;
import be.superjoran.domain.searchresult.ChosenOption;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChosenOptionServiceImpl implements ChosenOptionService {

    private final ChosenOptionDao chosenOptionDao;

    public ChosenOptionServiceImpl(ChosenOptionDao chosenOptionDao) {
        this.chosenOptionDao = chosenOptionDao;
    }

    @Override
    public List<ChosenOption> findByEventName(String eventName) {
        return this.chosenOptionDao.findByEventName(eventName);
    }
}
