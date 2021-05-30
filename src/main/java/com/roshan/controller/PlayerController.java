package com.roshan.controller;


import com.roshan.entity.Game;
import com.roshan.entity.Player;
import com.roshan.repository.GameRepository;
import com.roshan.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @GetMapping
    List<Player> getAllPlayers(){
       return playerRepository.findAll();
    }

    @PostMapping
    Player createPlayer(@RequestBody Player player){

       return playerRepository.save(player);
    }



}
