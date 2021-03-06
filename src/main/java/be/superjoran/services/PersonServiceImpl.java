package be.superjoran.services;

import be.superjoran.dao.PersonDao;
import be.superjoran.domain.Person;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person getPerson(String uuid) {
        return this.personDao.findOne(uuid);
    }

    @Override
    public List<Person> findAll() {
        return this.personDao.findAll();
    }

    @Override
    public void createUser(UserDetails user) {
        this.personDao.save((Person) user);
    }

    @Override
    public void updateUser(UserDetails user) {
        this.personDao.save((Person) user);
    }

    @Override
    public void deleteUser(String username) {
        this.personDao.deleteByUsername(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        //TODO
    }

    @Override
    public boolean userExists(String username) {
        return this.personDao.findByUsername(username) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Person result = this.personDao.findByUsername(username);
        if (result == null) {
            throw new UsernameNotFoundException(username);
        }
        return result;
    }

    @Override
    public Person findByUsername(String username) {
        return (Person) this.loadUserByUsername(username);
    }
}
