package com.jphuey.gameflix.service;

import com.jphuey.gameflix.model.Game;
import java.util.List;
import java.util.Optional;

public interface GamesService {
    List<Game> getAllGames();
    Optional<Game> getGameById(Long id);
    Game saveGame(Game game);
    void deleteGame(Long id);
}