package com.roshan.services;

import com.roshan.entity.Game;
import com.roshan.entity.Player;
import com.roshan.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public PlayerService(){

    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public  Player findByPlayerId(Long playerId){
        return playerRepository.findById(playerId).get();
    }
}
