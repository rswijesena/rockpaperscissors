package com.roshan.services;

import com.roshan.entity.Game;
import com.roshan.entity.Player;
import com.roshan.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    private PlayerService playerService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public PlayerService(){

    }
    public void setPlayerService(PlayerService playerService){
        this.playerService = playerService;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player save(Player player) {
        //check if email is taken

        return playerRepository.save(player);
    }

    public  Player findByPlayerId(Long playerId){
        return this.playerRepository.findById(playerId).get();
    }
}
