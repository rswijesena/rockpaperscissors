package com.roshan.services;

import com.roshan.entity.Player;
import com.roshan.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public  Optional<Player> findByPlayerId(Long playerId){
        return playerRepository.findById(playerId);
    }
}
