package entities;

import interfaces.Monster;

import java.util.Random;
/**
 * DefaultMonster class represents a basic implementation of the Monster interface.
 * It has attributes for health and attack ability.
 */
public class DefaultMonster implements Monster {
    private int health;
    private int attackAbility;
    /**
     * Constructs a DefaultMonster with initial health and default attack ability.
     *
     * @param health The initial health of the monster.
     */

    public DefaultMonster(int health) {
        this.health = health;
        this.attackAbility = 10; // Default attack ability
    }

    /**
     * Gets health of the monster.
     *
     * @return health of the monster.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Checks if the monster is dead.
     *
     * @return true if the monster is dead, false otherwise.
     */
    public boolean isDead() {
        return health <= 0;
    }

    /**
     * Reduces the monster's health by the damage amount.
     *
     * @param damage The amount of damage to be taken.
     */
    public void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Calculates the damage that the monster can deal based on its attack ability.
     *
     * @return A random value between 1 and the monster's attack ability (inclusive).
     */
    public int calculateDamage() {
        return new Random().nextInt(attackAbility) + 1; // Calculate damage based on attack ability
    }
}