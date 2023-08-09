# Text-Based RPG Game

This is a simple text-based RPG game written in Java. The game allows players to explore an imaginary world.

## User Story

As a player, I want to be able to explore the game world, encounter monsters, fight them, gain experience, level up, and find treasures.

## Use Cases

1. **Fighting Monsters**: When a player encounters a monster, they can choose to fight it. The player's attack ability and randomness determine the outcome of the fight.
2. **Gaining Experience and Level up**: Players gain experience points by defeating monsters. Once a player accumulates enough experience, they level up, increasing their attributes.
3. **Finding Treasures**: Occasionally, players can find treasures that restore their health.

## Design Patterns

This program demonstrates the use of the following design patterns:

1. **Factory Method Pattern**: The `MonsterFactory` interface and `DefaultMonsterFactory` class provide a way to create different types of monsters in a flexible and extendable manner.
2. **Strategy Pattern**: The `AttackStrategy` interface and its implementations (`HeavyHitStrategy` and `LightHitStrategy`) allow for different attack strategies to be chosen at runtime during a fight.

## Java Version and Testing Framework

- Java Version: Java 19 or later
- Testing Framework: JUnit

## Code Quality

The code adheres to SOLID principles and follows Clean Architecture. No code smells or violations of SOLID principles or CA are present in the codebase.
