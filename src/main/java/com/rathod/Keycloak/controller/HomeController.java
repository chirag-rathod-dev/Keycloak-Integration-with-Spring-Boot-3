package com.rathod.Keycloak.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {


    /**
     * Hello world endpoint that requires the "client_user" role.
     *
     * @return a string message
     */
    @GetMapping("/user")
    @PreAuthorize("hasRole('client_user')")
    public String user() {
        return "Hello from Spring boot & Keycloak";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('client_admin')")
    public String admin() {
        return "Hello from Spring boot & Keycloak - ADMIN";
    }
}
