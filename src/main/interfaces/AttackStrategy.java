package main.interfaces;

import main.entities.DefaultPlayer;

public interface AttackStrategy {
    int calculateDamage(Player player);
}