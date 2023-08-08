package main;
import main.controller.TextBasedGameController;
import main.entities.*;
import main.interfaces.*;

/**
 * The main class representing the Text-Based RPG game.
 */
public class TextBasedRPG {

    private static final int PLAYER_HEALTH = 100; // default health of the player

    /**
     * The main method to start the Text-Based RPG game.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Player player1 = new DefaultPlayer(PLAYER_HEALTH); // set a new player to the game
        GameController controller = new TextBasedGameController(player1);
        controller.start();
    }
}