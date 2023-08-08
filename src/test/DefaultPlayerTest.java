package test;
import main.entities.DefaultPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultPlayerTest {
    private DefaultPlayer player;

    @BeforeEach
    public void setUp() {
        player = new DefaultPlayer(100);
    }

    @Test
    public void testDamage() {
        int damage = player.calculateDamage();
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