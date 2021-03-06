package be.superjoran.controllers;

import be.superjoran.domain.Authority;
import be.superjoran.domain.Person;
import be.superjoran.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/register")
    public ModelAndView registerForm() {
        return new ModelAndView("register", "person", new Person());
    }

    @PostMapping("/register")
    public ModelAndView registerSubmit(@ModelAttribute Person person) {
        person.addAuthority(new Authority("USER"));
        this.personService.createUser(person);

        return new ModelAndView("login", "person", person);
    }

    @GetMapping("/login")
    public ModelAndView loginForm() {
        return new ModelAndView("login", "person", new Person());
    }
}
