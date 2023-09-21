package com.example.pp3_1_2.controllers;

import com.example.pp3_1_2.models.User;
import com.example.pp3_1_2.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UserServices userServices;

    private static final String REDIRECT_USERS_LIST_PAGE = "redirect:/users";

    @Autowired
    public UsersController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping(value = "/")
    public String helloPage() {
        return "/pages/index";
    }

    @GetMapping(value = "/users")
    public String indexUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userServices.indexUsers());
        return "/pages/users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/pages/new";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/pages/new";
        }
        userServices.add(user);
        return REDIRECT_USERS_LIST_PAGE;
    }

    @GetMapping("/users/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.getById(id));
        return "/pages/user";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServices.delete(userServices.getById(id));
        return REDIRECT_USERS_LIST_PAGE;
    }

    @GetMapping("/users/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.getById(id));
        return "/pages/edit";
    }

    @PatchMapping("/users/{id}")
    public String editUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "/pages/edit";
        }
        userServices.edit(user);
        return REDIRECT_USERS_LIST_PAGE;
    }

}