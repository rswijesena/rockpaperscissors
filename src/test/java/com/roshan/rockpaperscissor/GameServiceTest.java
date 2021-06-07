package com.roshan.rockpaperscissor;

import com.roshan.entity.Game;
import com.roshan.entity.Player;
import com.roshan.repository.GameRepository;
import com.roshan.repository.PlayerRepository;
import com.roshan.services.GameService;
import com.roshan.services.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
class GameServiceTest {

	@Mock
	private GameRepository gameRepository;
	@Mock
	private PlayerRepository playerRepository;
	@Mock
	private GameService underTestGame;
	@Mock
	private PlayerService underTestPlayer;


	@BeforeEach
	void setUp() {

		underTestGame = new GameService(gameRepository);
		underTestPlayer = new PlayerService(playerRepository);
	}


	@Test
	void canGetAllGames() {
		//when
		underTestGame.getAllGames();
		//then
		verify(gameRepository).findAll();
	}

	@Test
	void canAddGame(){
		Player player = new Player(1L,"roshan","roshan@gmail.com");

		underTestPlayer.save(player);
		//when
		Game game = new Game(1L,"R");
		//game.setPlayerId(player.getId());
		underTestGame.save(game);

		//then
		ArgumentCaptor<Game> gameArgumentCaptor =
				ArgumentCaptor.forClass(Game.class);
		verify(gameRepository).save(gameArgumentCaptor.capture());

		Game gameArg = gameArgumentCaptor.getValue();
		assertThat(gameArg).isEqualTo(game);

	}

	@Test
	void canPlayGame() {

		//when
		Game game = new Game(1L,"R","R");
		underTestGame.play(game);
		//then
		ArgumentCaptor<Game> gameArgumentCaptor =
				ArgumentCaptor.forClass(Game.class);
		verify(gameRepository).save(gameArgumentCaptor.capture());

		Game gameArg = gameArgumentCaptor.getValue();
		assertThat(gameArg).isEqualTo(game);

	}
}
