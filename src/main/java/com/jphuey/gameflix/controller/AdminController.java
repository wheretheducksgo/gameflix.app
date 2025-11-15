package com.jphuey.gameflix.controller;

import com.jphuey.gameflix.model.Game;
import com.jphuey.gameflix.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final GamesService gamesService;

    @Autowired
    public AdminController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("games", gamesService.getAllGames());
        return "admin";
    }

    @GetMapping("/add")
    public String addGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "game_details"; // can reuse template for add/edit
    }

    @PostMapping("/add")
    public String addGame(@ModelAttribute("game") Game game) {
        gamesService.saveGame(game);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable Long id) {
        gamesService.deleteGame(id);
        return "redirect:/admin";
    }
}