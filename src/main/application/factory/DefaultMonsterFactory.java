package application.factory;

import entities.DefaultMonster;
import interfaces.*;
/**
 * DefaultMonsterFactory class implements the MonsterFactory interface to create instances
 * of DefaultMonster with the specified health.
 */
public class DefaultMonsterFactory implements MonsterFactory {
    /**
     * Creates a new instance of DefaultMonster.
     *
     * @param health The initial health of the created monster.
     * @return A new DefaultMonster instance.
     */
    @Override
    public Monster createMonster(int health) {
        return new DefaultMonster(health);
    }
}
