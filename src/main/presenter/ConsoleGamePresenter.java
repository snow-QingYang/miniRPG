package main.presenter;
import main.entities.*;
import main.interfaces.GamePresenter;
/**
 * ConsoleGamePresenter class implements the GamePresenter interface and is responsible for
 * displaying game-related information to the console.
 */
public class ConsoleGamePresenter  implements GamePresenter {
    /**
     * Display a message to the console.
     *
     * @param message The message to be displayed.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
    /**
     * Display the player's status (level, health, and experience) to the console.
     *
     * @param player The player whose status needs to be displayed.
     */
    public void displayPlayerStatus(Player player) {
        displayMessage("Current level: " + player.getLevel());
        displayMessage("Current health: " + player.getHealth());
        displayMessage("Current experience: " + player.getExperience());
    }
    /**
     * Display the start message to the console, indicating the available actions.
     */
    public void displayStartMessage()
    {
        displayMessage("Choose your action:");
        displayMessage("1. Explore");
        displayMessage("2. Exit");
    }
}
