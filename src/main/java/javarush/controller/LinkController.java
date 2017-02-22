package javarush.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

    @GetMapping("/")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

    @GetMapping("/index")
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }
}
