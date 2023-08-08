package main;
import main.application.factory.DefaultMonsterFactory;
import main.entities.*;
import main.interfaces.*;
import main.presenter.*;
import main.application.usecase.*;

import java.util.Random;
import java.util.Scanner;
/**
 * The main class representing the Text-Based RPG game.
 */
public class TextBasedRPG {
    private static final int MAX_MONSTER_HEALTH = 100;
    private static final int PLAYER_HEALTH = 100;
    private static final int EXPERIENCE_PER_MONSTER = 20;
    private static final int DEFAULT_EXPERIENCE_FOR_LEVEL_UP = 20;

    private Player player;
    private GamePresenter presenter;
    private MonsterFactory factory;
    private FightMonsterUseCase fightMonsterUseCase;
    private FindTreasureUseCase findTreasureUseCase;
    private LevelUpUseCase levelUpUseCase;
    private CreateMonsterUseCase createMonsterUseCase;
    private Random random;
    private Scanner scanner;

    /**
     * Constructs a TextBasedRPG instance, initializing the game components.
     */
    public TextBasedRPG() {
        player = new Player(PLAYER_HEALTH);
        presenter = new ConsoleGamePresenter();
        factory = new DefaultMonsterFactory();
        levelUpUseCase = new LevelUpUseCase(presenter, DEFAULT_EXPERIENCE_FOR_LEVEL_UP);
        fightMonsterUseCase = new FightMonsterUseCase(presenter,levelUpUseCase);
        findTreasureUseCase = new FindTreasureUseCase(presenter);
        createMonsterUseCase = new CreateMonsterUseCase(factory);
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }
    /**
     * Starts the Text-Based RPG game.
     */
    public void start() {
        System.out.println("Welcome to the Text-Based RPG Game!");

        while (!player.isDead()) {
            presenter.displayPlayerStatus(player);
            presenter.displayStartMessage();
            int choice = scanner.nextInt();

            if (choice == 1) {
                explore();
            } else if (choice == 2) {
                presenter.displayMessage("Exiting the game...");
                break;
            } else {
                presenter.displayMessage("Invalid choice! Try again.");
            }
        }

        presenter.displayMessage("Game Over!");
        scanner.close();
    }
    /**
     * explore part of the Text-Based RPG game.
     */
    private void explore() {
        int chance = random.nextInt(10);

        if (chance < 3) {
            presenter.displayMessage("You encountered a monster!");
            int monsterHealth = random.nextInt(MAX_MONSTER_HEALTH) + 1;
            Monster monster = createMonsterUseCase.execute(monsterHealth);
            fightMonsterUseCase.execute(player, monster, EXPERIENCE_PER_MONSTER,random);
        } else if (chance < 6) {
            findTreasureUseCase.execute(player);
        } else {
            presenter.displayMessage("You explored the area but found nothing interesting.");
        }
    }
    /**
     * The main method to start the Text-Based RPG game.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        TextBasedRPG game = new TextBasedRPG();
        game.start();
    }
}