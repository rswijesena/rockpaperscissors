package com.roshan.entity;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game(Long id, Long playerId, Player player, String playerShape, String gameResults, String computerShape) {
        this.id = id;
        this.playerId = playerId;
        this.player = player;
        this.playerShape = playerShape;
        this.gameResults = gameResults;
        this.computerShape = computerShape;
    }

    private String playerShape;

    public String getPlayerShape() {
        return playerShape;
    }

    public void setPlayerShape(String playerShape) {
        this.playerShape = playerShape;
    }

    private String gameResults;


    public String getComputerShape() {
        return computerShape;
    }

    public void setComputerShape(String computerShape) {
        this.computerShape = computerShape;
    }

    public Game(Long playerId, String playerShape, String computerShape) {
        this.playerId = playerId;
        this.playerShape = playerShape;
        this.computerShape = computerShape;
    }
    public Game() {
    }

    private String computerShape;

    public String getGameResults() {
        return gameResults;
    }

    public void setGameResults(String gameResults) {
        this.gameResults = gameResults;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game(Long playerId, String playerShape) {
        this.playerId = playerId;
        this.playerShape = playerShape;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

}
