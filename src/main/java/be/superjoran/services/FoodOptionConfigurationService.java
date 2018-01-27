package be.superjoran.services;

import be.superjoran.domain.FoodOptionConfiguration;

import java.util.List;

public interface FoodOptionConfigurationService {

    List<FoodOptionConfiguration> findAllByEventOwnerUsername(String username);

    void copyFoodOptionConfiguration(String eventName, String foodOptionConfigurationUuid);

    FoodOptionConfiguration findByUuid(String uuid);

    FoodOptionConfiguration findByEventNameAndName(String eventName, String name);

    FoodOptionConfiguration createOrUpdate(FoodOptionConfiguration foodOptionConfiguration);

    void deleteByEventNameAndName(String eventName, String name);

    List<FoodOptionConfiguration> findAllByEventName(String eventName);
}
