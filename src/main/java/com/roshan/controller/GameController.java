package com.roshan.controller;

import com.roshan.entity.Game;
import com.roshan.entity.Player;
import com.roshan.repository.PlayerRepository;
import com.roshan.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rps/v1")
public class GameController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    List<Game> getAllGames(){
        return gameService.getAllGames();
    }
    @PostMapping("/game")
    Game createGame(@RequestBody Game game){
        return gameService.save(game);
    }

    @PostMapping("/game/play")
    Game playGame(@RequestBody Game game){
        return gameService.play(game);
    }

}
