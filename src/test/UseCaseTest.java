package test;
import static org.junit.jupiter.api.Assertions.*;

import main.application.usecase.*;
import main.entities.*;
import main.interfaces.*;
import main.presenter.ConsoleGamePresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class UseCaseTest {
    private Player player;
    private FindTreasureUseCase findTreasureUseCase;
    private LevelUpUseCase levelUpUseCase;

    @BeforeEach
    public void setUp() {
        player = new Player(100);
        ConsoleGamePresenter presenter = new ConsoleGamePresenter();
        levelUpUseCase = new LevelUpUseCase(presenter, 20);
        findTreasureUseCase = new FindTreasureUseCase(presenter);
    }

    @Test
    public void testFindTreasureUseCase() {
        int initialPlayerHealth = player.getHealth();

        findTreasureUseCase.execute(player);

        assertTrue(initialPlayerHealth < player.getHealth());
    }

    @Test
    public void testLevelUpUseCase() {
        player.gainExperience(20);
        levelUpUseCase.execute(player);

        assertEquals(2, player.getLevel());
    }
}