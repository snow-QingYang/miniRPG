package main.application.usecase;

import main.entities.*;
import main.interfaces.*;
import java.util.Random;

/**
 * FindTreasureUseCase class represents a use case for simulating a player finding a treasure chest and gaining health.
 */
public class FindTreasureUseCase {
    private GamePresenter presenter;

    /**
     * Constructs a FindTreasureUseCase instance with the specified GamePresenter.
     *
     * @param presenter The GamePresenter instance used for displaying information to the player.
     */
    public FindTreasureUseCase(GamePresenter presenter) {
        this.presenter = presenter;
    }
    /**
     * Executes the use case to simulate the player finding a treasure chest and gaining health.
     *
     * @param player The player who finds the treasure chest and gains health.
     */
    public void execute(Player player) {
        Random random = new Random();
        int healthBonus = random.nextInt(20) + 1;
        player.gainHealth(healthBonus);
        presenter.displayMessage("You found a treasure chest!");
        presenter.displayMessage("You gained " + healthBonus + " HP.");
    }
}