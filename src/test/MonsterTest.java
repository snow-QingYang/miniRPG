package test;

import static org.junit.jupiter.api.Assertions.*;

import main.entities.*;
import main.interfaces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonsterTest {
    private Monster monster;

    @BeforeEach
    public void setUp() {
        monster = new DefaultMonster(100);
    }

    @Test
    public void testGetHealth() {
        assertEquals(100, monster.getHealth());
    }

    @Test
    public void testIsDead() {
        assertFalse(monster.isDead());
        monster.takeDamage(100);
        assertTrue(monster.isDead());
    }

    @Test
    public void testTakeDamage() {
        monster.takeDamage(50);
        assertEquals(50, monster.getHealth());
        monster.takeDamage(30);
        assertEquals(20, monster.getHealth());
    }

    @Test
    public void testCalculateDamage() {
        int damage = monster.calculateDamage();
        assertTrue(damage >= 1 && damage <= 10);
    }
}