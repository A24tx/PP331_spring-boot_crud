package com.ax.crud.controllers;

import com.ax.crud.model.User;
import com.ax.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TableController {

    private UserService us;

    public TableController(UserService us) {
        this.us = us;
    }

    @GetMapping(value = "/")
    public String index() {
        return "redirect:/table";
    }

    @GetMapping("/table")
    public String table(Model model) {
        model.addAttribute("users", us.getUsers());
        return "table";
    }

    @GetMapping("/updateUserForm/{id}")
    public String showFormForUpdating(@PathVariable(value = "id") long id, Model model) {
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
    public String showFormForAdding(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return "addUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        us.saveUser(user);
        return "redirect:/table";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") long id, Model model) {
        us.removeUser(id);
        return "redirect:/table";
    }
}