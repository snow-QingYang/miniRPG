package main.application.usecase;

import main.interfaces.Monster;
import main.interfaces.MonsterFactory;
/**
 * CreateMonsterUseCase class represents a use case for creating monsters using a provided
 * MonsterFactory instance.
 */
public class CreateMonsterUseCase {
    private MonsterFactory monsterFactory;

    /**
     * Constructs a CreateMonsterUseCase instance with the specified MonsterFactory.
     *
     * @param monsterFactory The MonsterFactory instance used for creating monsters.
     */
    public CreateMonsterUseCase(MonsterFactory monsterFactory) {
        this.monsterFactory = monsterFactory;
    }

    /**
     * Executes the use case to create a monster with the specified health.
     *
     * @param health The initial health of the created monster.
     * @return A new Monster instance created using the provided MonsterFactory.
     */
    public Monster execute(int health) {
        return monsterFactory.createMonster(health);
    }
}