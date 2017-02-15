package javarush.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

    @RequestMapping("/")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

    @RequestMapping("/index")
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }
}
