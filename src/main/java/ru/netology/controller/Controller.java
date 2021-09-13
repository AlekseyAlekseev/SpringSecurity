package ru.netology.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/help")
    public String getCityOfResidence() {
        return "You have switched to an assistant, how can we help?";
    }

    @GetMapping("/auth")
    public String authorizationMenu() {
        return "Hello, " + SecurityContextHolder.getContext().getAuthentication().getName() +
                "! You have entered the authorized user menu";
    }
}
