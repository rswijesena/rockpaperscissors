package com.roshan.rockpaperscissor;

import com.roshan.repository.GameRepository;
import com.roshan.repository.PlayerRepository;
import com.roshan.services.GameService;
import com.roshan.services.PlayerService;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerServiceTest {
    @Mock
    private PlayerRepository playerRepository;
    private PlayerService underTest;
}
