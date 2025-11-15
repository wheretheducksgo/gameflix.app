package com.jphuey.gameflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Thymeleaf will resolve login.html
    }

}
