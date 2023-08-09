package application.Strategy;

import interfaces.*;

/**
 * HeavyHitStrategy class implements the AttackStrategy interface and represents a strategy
 * for performing heavy hits with a chance of missing.
 */
public class HeavyHitStrategy implements AttackStrategy {
    private static final double MISS_RATE = 0.5;
    /**
     * Calculates the damage based on the heavy hit strategy, with a chance of missing.
     * If the attack misses, the damage is set to 0; otherwise, it's doubled.
     *
     * @param player The player performing the attack.
     * @return The calculated damage based on the strategy.
     */
    public int calculateDamage(Player player) {
        int baseDamage = player.calculateDamage();
        if (Math.random() < MISS_RATE) {
            return baseDamage * 2;
        } else {
            return 0;
        }
    }
}
