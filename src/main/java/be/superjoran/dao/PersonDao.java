package be.superjoran.dao;

import be.superjoran.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, String> {
    void deleteByUsername(String username);
    Person findByUsername(String username);
}
