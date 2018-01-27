package be.superjoran.controllers;

import be.superjoran.domain.Event;
import be.superjoran.utilities.SecurityUtility;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class HomeController {

    @RequestMapping("/")
    public String welcome() {
        return "redirect:home";
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        if (SecurityUtility.isUserLoggedIn()) {
            return new ModelAndView("redirect:/profile");
        }
        return new ModelAndView("home", "event", new Event());
    }
}
