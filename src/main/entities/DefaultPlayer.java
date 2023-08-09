package entities;

import interfaces.Player;

import java.util.Random;
/**
 * Represents a player in the text-based RPG game.
 */

public class DefaultPlayer implements Player {
    private int health;
    private int experience;
    private int attackAbility;
    private int level;

    /**
     * Creates a new player with the initial health ,level, experience and attack ability.
     *
     * @param health The initial health of the player.
     */
    public DefaultPlayer(int health) {
        this.health = health;
        this.experience = 0;
        this.attackAbility = 10;
        this.level = 1;
    }

    /**
     * Get the player's current health.
     *
     * @return The current health of the player.
     */
    public int getHealth() {
        return health;
    }
    /**
     * Get Player's experience.
     * @return Player's experience.
     */

    public int getExperience() {
        return experience;
    }

    /**
     * Check if the player is dead.
     *
     * @return true if the player's health is less than or equal to 0, false otherwise.
     */
    public boolean isDead() {
        return health <= 0;
    }

    /**
     * Get the player's current level.
     *
     * @return The current level of the player.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Inflict damage to the player.
     *
     * @param damage The amount of damage to be taken.
     */
    public void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Increase the player's experience by the given amount.
     *
     * @param experience The amount of experience to be gained.
     */
    public void gainExperience(int experience) {
        this.experience += experience;
    }

    /**
     * Increase the player's health by the given amount.
     *
     * @param healthBonus The amount of health to be gained.
     */
    public void gainHealth(int healthBonus) {
        health += healthBonus;
    }

    /**
     * Calculate damage based on the player's attack ability and a random number generator.
     *
     * @return The calculated damage.
     */
    public int calculateDamage() {
        Random random = new Random();
        return random.nextInt(attackAbility) + 1;}
    /**
     * Level up the player, increasing level, health, and attack ability.
     */
    public void levelUp() {
        level++;
        health += 20; // Increase HP by 20 on level up
        attackAbility += 5; // Increase attack ability by 5 on level up
    }
    /**
     * Get the player's current attack ability.
     *
     * @return The current attack ability of the player.
     */
    public int getAttackAbility() {return this.attackAbility;}

    /**
     * Deduct experience from the player by the given amount.
     * If experience goes below 0, it is set to 0.
     *
     * @param experience The amount of experience to be deducted.
     */
    public void deductExperience(int experience) {
        this.experience -= experience;
        if (this.experience < 0) {
            this.experience = 0;
        }
    }
}