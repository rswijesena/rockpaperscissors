package com.roshan.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roshan.services.GameAttributes;

import javax.persistence.*;
import java.util.Set;
import com.roshan.services.GameAttributes.*;


/**
 * This class contains Player attributes.
 */
@Entity
public class Player {

    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )private Long id;

    private String name;
    private String email;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="player_id")
    private Set<Game> games;

    public Player(){

    }

    public Player(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<Game> getGames() {
        return this.games;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
