package be.superjoran.services;

import be.superjoran.domain.searchresult.ChosenOption;

import java.util.List;

public interface ChosenOptionService {
    List<ChosenOption> findByEventName(String eventName);
}
