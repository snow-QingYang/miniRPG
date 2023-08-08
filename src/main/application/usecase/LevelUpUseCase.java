package main.application.usecase;

import main.interfaces.*;

/**
 * LevelUpUseCase class represents a use case for handling player level-ups based on experience gained.
 */
public class LevelUpUseCase {
    private GamePresenter presenter;
    private int experienceRequiredForLevelUp;

    /**
     * Constructs a LevelUpUseCase instance with the specified GamePresenter and experience required for level up.
     *
     * @param presenter The GamePresenter instance used for displaying information to the player.
     * @param experienceRequiredForLevelUp The amount of experience required for a level up.
     */
    public LevelUpUseCase(GamePresenter presenter, int experienceRequiredForLevelUp) {
        this.presenter = presenter;
        this.experienceRequiredForLevelUp = experienceRequiredForLevelUp;
    }

    /**
     * Executes the use case to handle player level-ups based on experience.
     *
     * @param player The player whose level-up status needs to be checked and processed.
     */
    public void execute(Player player) {
        int currentExperience = player.getExperience();

        if (currentExperience >= experienceRequiredForLevelUp) {
            player.levelUp();
            player.deductExperience(experienceRequiredForLevelUp);
            presenter.displayMessage("Congratulations! You leveled up to level " + player.getLevel());
            presenter.displayMessage("Your attack ability is now: " + player.getAttackAbility());
        }
    }
}
