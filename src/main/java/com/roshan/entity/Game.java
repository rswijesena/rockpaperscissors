package com.roshan.entity;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;
    private boolean isUserWon;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }
    @Transient
    private String Shape;

    public String getShape() {
        return Shape;
    }

    public void setShape(String shape) {
        Shape = shape;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public boolean getIsUserWon() {
        return isUserWon;
    }

    public void setIsUserWon(boolean isUserWon) {
        this.isUserWon = isUserWon;
    }
}
