package com.jphuey.gameflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/catalog")
    public String catalogPage() {
        return "catalog";
    }
}