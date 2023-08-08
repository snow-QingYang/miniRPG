package main.interfaces;

public interface Player {
    int getHealth();
    int getExperience();
    void gainHealth(int health);
    void gainExperience(int experienceToAdd);
    int getAttackAbility();

    int getLevel();

    void deductExperience(int experience);
    void takeDamage(int damage);
    void levelUp();
    int calculateDamage();
    boolean isDead();
}
