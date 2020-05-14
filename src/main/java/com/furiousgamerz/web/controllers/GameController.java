package com.furiousgamerz.web.controllers;

import com.furiousgamerz.web.dtos.GameDto;
import com.furiousgamerz.web.mapper.GameMapper;
import com.furiousgamerz.web.models.Game;
import com.furiousgamerz.web.repositories.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    final GameMapper gameMapper;
    final GameRepository gameRepository;

    public GameController(GameMapper gameMapper, GameRepository gameRepository) {
        this.gameMapper = gameMapper;
        this.gameRepository = gameRepository;
    }

    @PostMapping("/games")
    public GameDto create(@RequestBody GameDto gameDto) {
        Game game = gameMapper.gameDtoToGame(gameDto);
        gameRepository.save(game);
        return gameMapper.gameToGameDto(game);
    }

    @GetMapping("/games")
    public List<GameDto> findAll() {
        return gameMapper.gameToGameDto(gameRepository.findAll());
    }

    @GetMapping("/games/{id}")
    public GameDto findOne(@PathVariable("id") Long id) {
        return gameMapper.gameToGameDto(gameRepository.findById(id).get());
    }
}
