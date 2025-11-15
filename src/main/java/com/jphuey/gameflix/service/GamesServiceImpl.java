package com.jphuey.gameflix.service;

import com.jphuey.gameflix.model.Game;
import com.jphuey.gameflix.repository.GamesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesServiceImpl implements GamesService {

    private final GamesRepository gamesRepository;

    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gamesRepository.findAll();
    }

    @Override
    public Optional<Game> getGameById(Long id) {
        return gamesRepository.findById(id);
    }

    @Override
    public Game saveGame(Game game) {
        return gamesRepository.save(game);
    }

    @Override
    public void deleteGame(Long id) {
        gamesRepository.deleteById(id);
    }
}