package com.roshan.controller;

import com.roshan.entity.Game;
import com.roshan.entity.Player;
import com.roshan.repository.GameRepository;
import com.roshan.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    List<Game> getAllGames(){
        return gameRepository.findAll();
    }
    @PostMapping
    Game createGame(@RequestBody Game game){
        return gameRepository.save(game);
    }

    @PostMapping("/play")
    Game playGame(@RequestBody Game game){

        game.setIsUserWon(true);
        Game games1 = gameRepository.save(game);

        Player player = playerRepository.findById(game.getPlayerId()).get();

        games1.setPlayer(player);
        return gameRepository.save(games1);

    }

}
