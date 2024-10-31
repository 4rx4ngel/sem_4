package com.biziukov.task_2.controllers;

import com.biziukov.task_2.domain.User;
import com.biziukov.task_2.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
@Log
public class UserController {

    private UserService service;

    @GetMapping
    public String getHome() {
        log.info("Открыта начальная страница");
        return "/home";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", service.select());
        log.info("Открыта страница с базой данных пользователей");
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        service.save(user);
        log.info("Create user: " + user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        service.delete(id);
        log.info("Пользователь с  id = " + id + " удален.");
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(User user) {
        return "user-update";
    }

    @PostMapping("/user-update")
    public String update(User user) {
        service.update(user);
        log.info("Данные о пользователе: " + user + " обновлены.");
        return "redirect:/users";
    }

}