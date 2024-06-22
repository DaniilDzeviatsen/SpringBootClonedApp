package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "pages/users";
    }

    @GetMapping("/")
    public String getUserByID(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "pages/show";
    }

    @GetMapping("/new")
    public String showSignUpForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:pages/users";
    }

    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "pages/edit";
    }

    @PatchMapping("/")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:pages/users";
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:pages/users";
    }
}
