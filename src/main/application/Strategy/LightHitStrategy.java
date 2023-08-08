package main.application.Strategy;

import main.entities.DefaultPlayer;
import main.interfaces.*;

/**
 * LightHitStrategy class implements the AttackStrategy interface and represents a strategy
 * for performing light hits without any additional effects.
 */
public class LightHitStrategy implements AttackStrategy {
    /**
     * Calculates the damage based on the light hit strategy.
     *
     * @param player The player performing the attack.
     * @return The calculated damage based on the player's damage calculation.
     */
    @Override
    public int calculateDamage(Player player) {
        return player.calculateDamage();
    }
}