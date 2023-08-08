package main.controller;

import main.application.factory.DefaultMonsterFactory;
import main.application.usecase.*;
import main.interfaces.*;
import main.presenter.ConsoleGamePresenter;

import java.util.Random;
import java.util.Scanner;

public class TextBasedGameController implements GameController {
    private static final int MAX_MONSTER_HEALTH = 100;
    private static final int EXPERIENCE_PER_MONSTER = 20;
    private static final int DEFAULT_EXPERIENCE_FOR_LEVEL_UP = 20;

    private final FightMonsterUseCase fightMonsterUseCase;
    private final FindTreasureUseCase findTreasureUseCase;
    private final CreateMonsterUseCase createMonsterUseCase;
    private final GamePresenter presenter;
    private final Player player;
    private final Scanner scanner;
    private final Random random;


    public TextBasedGameController( Player player
            ) {

        this.player = player;
        this.presenter = new ConsoleGamePresenter();
        this.scanner = new Scanner(System.in);
        LevelUpUseCase levelUpUseCase = new LevelUpUseCase(presenter, DEFAULT_EXPERIENCE_FOR_LEVEL_UP);
        this.fightMonsterUseCase = new FightMonsterUseCase(presenter, levelUpUseCase);
        this.findTreasureUseCase = new FindTreasureUseCase(presenter);
        this.createMonsterUseCase = new CreateMonsterUseCase(new DefaultMonsterFactory());
        this.random = new Random();
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
    public void explore() {
        int chance = random.nextInt(10);

        if (chance < 3) {
            presenter.displayMessage("You encountered a monster!");
            int monsterHealth = random.nextInt(MAX_MONSTER_HEALTH) + 1;
            Monster monster = createMonsterUseCase.execute(monsterHealth); // use factory to create monster
            fightMonsterUseCase.execute(player, monster, EXPERIENCE_PER_MONSTER);
        } else if (chance < 6) {
            findTreasureUseCase.execute(player);
        } else {
            presenter.displayMessage("You explored the area but found nothing interesting.");
        }
    }
}
