package javarush.controller;

import javarush.model.User;
import javarush.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("add-user-form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addingUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add-user-form");
        }

        ModelAndView modelAndView = new ModelAndView("home");
        userService.addUser(user);

        String message = "User was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUserPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit-user-form");
        User user = userService.getUser(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editingUser (@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("edit-user-form");
        }

        ModelAndView modelAndView = new ModelAndView("home");
        userService.updateUser(user);

        String message = "User was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView searchUsers(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("found-by-name");
        List<User> users = userService.searchUsers(name);

        String message;
        boolean success = false;

        if (users.size() > 0) {
            message = "User/s was successfully found";
            success = true;
            modelAndView.addObject("users", users);
        } else
            message = "User not found!";

        modelAndView.addObject("message", message);
        modelAndView.addObject("success", success);

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("home");
        userService.deleteUser(id);

        String message = "User was successfully deleted.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("list-of-users");
        List<User> users = userService.getUsers();

        modelAndView.addObject("users", users);

        return modelAndView;
    }
}
