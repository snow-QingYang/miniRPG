package main.application.Strategy;

import main.entities.Player;
import main.interfaces.AttackStrategy;

import java.util.Random;
/**
 * LightHitStrategy class implements the AttackStrategy interface and represents a strategy
 * for performing light hits without any additional effects.
 */
public class LightHitStrategy implements AttackStrategy {
    /**
     * Calculates the damage based on the light hit strategy.
     *
     * @param player The player performing the attack.
     * @param random The random number generator used for damage calculation.
     * @return The calculated damage based on the player's damage calculation.
     */
    @Override
    public int calculateDamage(Player player, Random random) {
        return player.calculateDamage(random);
    }
}