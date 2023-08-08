package test;
import main.entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player(100);
    }

    @Test
    public void testDamage() {
        int damage = player.calculateDamage(new Random());
        assertTrue(damage >= 0 && damage <= 10);
    }

    @Test
    void playerShouldLevelUp() {
        int initialLevel = player.getLevel();
        player.gainExperience(20);
        player.levelUp();
        assertEquals(initialLevel + 1, player.getLevel());
    }
}