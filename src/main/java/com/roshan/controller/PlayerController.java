package com.roshan.controller;


import com.roshan.entity.Game;
import com.roshan.entity.Player;
import com.roshan.repository.GameRepository;
import com.roshan.repository.PlayerRepository;
import com.roshan.services.GameService;
import com.roshan.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rps/v1")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    List<Player> getAllPlayers(){
       return playerService.getAllPlayers();
    }

    @PostMapping("/player")
    Player createPlayer(@RequestBody Player player){
       return playerService.save(player);
    }



}
