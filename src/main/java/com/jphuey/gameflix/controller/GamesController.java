package com.jphuey.gameflix.controller;

import com.jphuey.gameflix.model.Game;
import com.jphuey.gameflix.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GamesController {

    private final GamesService gamesService;

    @Autowired
    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping("/{id}")
    public String gameDetails(@PathVariable Long id, Model model) {
        Game game = gamesService.getGameById(id).orElse(null);
        if (game == null) return "redirect:/catalog";
        model.addAttribute("game", game);
        return "game_details";
    }
}