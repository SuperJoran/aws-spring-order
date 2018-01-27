package be.superjoran.services;

import be.superjoran.domain.searchresult.PersonChoicesSearchResult;

import java.util.Collection;

public interface PersonChoicesSearchResultService {

    Collection<PersonChoicesSearchResult> findParticipantsByEventName(String eventName);

}
