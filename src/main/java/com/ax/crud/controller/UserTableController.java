package com.ax.crud.controller;

import com.ax.crud.model.User;
import com.ax.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserTableController {

    private UserService us;

    public UserTableController(UserService us) {
        this.us = us;
    }

    @GetMapping(value = "/")
    public String showIndex() {
        return "redirect:/table";
    }

    @GetMapping("/table")
    public String showUserTable(Model model) {
        model.addAttribute("users", us.getUsers());
        return "table";
    }

    @GetMapping("/updateUserForm/{id}")
    public String showFormForUpdatingUser(@PathVariable(value = "id") long id, Model model) {
        User user = us.getUserById(id);

        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        us.saveUser(user);
        return "redirect:/table";
    }

    @GetMapping("/newUserForm")
    public String showFormForAddingUser(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return "addUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        us.updateUser(user);
        return "redirect:/table";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") long id, Model model) {
        us.removeUser(id);
        return "redirect:/table";
    }
}