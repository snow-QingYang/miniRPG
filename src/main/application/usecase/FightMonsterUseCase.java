package main.application.usecase;


import main.interfaces.AttackStrategy;
import main.application.Strategy.HeavyHitStrategy;
import main.application.Strategy.LightHitStrategy;
import main.entities.*;
import main.interfaces.GamePresenter;
import main.interfaces.Monster;

import java.util.Random;
import java.util.Scanner;
/**
 * FightMonsterUseCase class represents a use case for battles between a player and a monster.
 */
public class FightMonsterUseCase {
    private GamePresenter presenter;
    private LevelUpUseCase levelUpUseCase;

    /**
     * Constructs a FightMonsterUseCase instance with the specified dependencies.
     *
     * @param presenter The GamePresenter instance used for displaying information to the player.
     * @param levelUpUseCase The LevelUpUseCase instance used for checking player level-up conditions.
     */
    public FightMonsterUseCase(GamePresenter presenter, LevelUpUseCase levelUpUseCase) {
        this.presenter = presenter;
        this.levelUpUseCase = levelUpUseCase;
    }
    /**
     * Executes the use case to simulate a battle between a player and a monster.
     *
     * @param player The player participating in the battle.
     * @param monster The monster the player is fighting against.
     * @param experiencePerMonster The amount of experience gained when defeating a monster.
     * @param random The random number generator used for various calculations.
     */
    public void execute(Player player, Monster monster, int experiencePerMonster, Random random) {
        Scanner scanner = new Scanner(System.in);

        while (!player.isDead() && !monster.isDead()) {
            presenter.displayPlayerStatus(player);
            presenter.displayMessage("Monster health: " + monster.getHealth());
            presenter.displayMessage("Choose your action:");
            presenter.displayMessage("1. HeavyHit");
            presenter.displayMessage("2. LightHit");
            presenter.displayMessage("3. Run");
            int choice = scanner.nextInt();
            AttackStrategy strategy;

            if (choice == 1) {
               strategy = new HeavyHitStrategy();
            }
            else if (choice ==2)
            {
                strategy = new LightHitStrategy();
            }
            else if (choice == 3) {
                presenter.displayMessage("You ran away from the monster!");
                return;
            } else {
                presenter.displayMessage("Invalid choice! Try again.");
                continue;
            }
            int player_damage = strategy.calculateDamage(player,random);
            int monster_damage = monster.calculateDamage();
            player.takeDamage(monster_damage);
            monster.takeDamage(player_damage);
        }


        if (player.isDead()) {
            presenter.displayMessage("You were defeated by the monster!");
        } else {
            presenter.displayMessage("You defeated the monster!");
            player.gainExperience(experiencePerMonster);
            levelUpUseCase.execute(player); // Check for level up
        }
    }
}



