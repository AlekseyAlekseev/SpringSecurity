package ru.netology.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class Controller {

    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String read() {
        return "Hello, " + SecurityContextHolder.getContext().getAuthentication().getName()
                + ". You went to the reading page";
    }

    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public String write() {
        return "Hi, " + SecurityContextHolder.getContext().getAuthentication().getName()
                + ". You went to the recording page";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String delete() {
        return "Hey, " + SecurityContextHolder.getContext().getAuthentication().getName()
                + ". You have been taken to the deletion page";
    }

    @GetMapping("/named")
    @PreAuthorize("#username == authentication.principal.username")
    public String named(String username) {
        return "Hello, " + username + ". You are redirected to the /named page";
    }
}
