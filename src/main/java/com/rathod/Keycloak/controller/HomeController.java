package com.rathod.Keycloak.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    /**
     * Greet the admin.
     *
     * @return "Hello Admin"
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('client_admin')")
    public String admin() {
        return "Hello Admin";
    }

    /**
     * Greet the user.
     *
     * @return "Hello User"
     */

    @GetMapping("/user")
    @PreAuthorize("hasRole('client_user')")
    public String user() {
        return "Hello User";
    }

}
