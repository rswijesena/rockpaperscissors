package com.roshan.services;

import com.roshan.entity.Game;
import com.roshan.entity.Player;
import com.roshan.repository.GameRepository;
import com.roshan.repository.PlayerRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roshan.exception.BadRequestException;
import com.roshan.services.GameAttributes.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameService  {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerService playerService;

    private GAMEINPUTS gameUserInput;
    private GAMEINPUTS gameComputerInput;
    private GAMERESULTS gameresults;
    private Random rand;

    public GAMEINPUTS getPlayerChoice(String playerChoice) {

        switch (playerChoice)
        {
            case "R":
                return GameAttributes.GAMEINPUTS.ROCK;
            case "P":
                return GameAttributes.GAMEINPUTS.PAPER;
            case "S":
                return GameAttributes.GAMEINPUTS.SCISSORS;
        }
        throw new BadRequestException(
                "Invalid Input, Values should be R,P OR S");
    }

    public GAMEINPUTS getComputerInput(){

        rand = new Random();
        int computerChoice = rand.nextInt(3) + 1;
        switch (computerChoice)
        {
            case 1:
                return GAMEINPUTS.ROCK;
            case 2:
                return GAMEINPUTS.PAPER;
        }
        return GAMEINPUTS.SCISSORS;
    }


    public List<Game> getAllGames() {
        try {
            return gameRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Error while fetching all games " + e.getMessage());
        }
    }


    public Game save(Game game) {

        try {
            return gameRepository.save(game);
        } catch (Exception e) {
            throw new IllegalStateException("Error while playing new game " + e.getMessage());
        }
    }

    public Game play(Game game) {

        try {
            gameUserInput = this.getPlayerChoice(game.getPlayerShape());
            gameComputerInput = this.getComputerInput();
            gameresults = this.getResults();

            switch (gameresults) {
                case WIN:
                    game.setGameResults("win");
                    break;
                case DRAW:
                    game.setGameResults("draw");
                    break;
                case LOSE:
                    game.setGameResults("lose");
                    break;
            }
            game.setComputerShape(gameComputerInput.toString());
            game.setPlayerShape(gameUserInput.toString());

            return gameRepository.save(game);
        } catch (Exception e){
            throw new IllegalStateException("Error while playing new game " + e.getMessage());
        }
    }

    public GAMERESULTS getResults(){
        if(gameUserInput == gameComputerInput) {
            return GAMERESULTS.DRAW;
        }
        switch (gameUserInput){
            case ROCK:
                return (gameComputerInput == GAMEINPUTS.SCISSORS ? GAMERESULTS.WIN : GAMERESULTS.LOSE);
            case PAPER:
                return (gameComputerInput == GAMEINPUTS.ROCK ? GAMERESULTS.WIN : GAMERESULTS.LOSE);
            case SCISSORS:
                return (gameComputerInput == GAMEINPUTS.PAPER ? GAMERESULTS.WIN : GAMERESULTS.LOSE);
        }
        return GAMERESULTS.LOSE;
    }
}
