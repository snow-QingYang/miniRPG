package main.interfaces;

import main.entities.Player;
import java.util.Random;
public interface AttackStrategy {
    int calculateDamage(Player player, Random random);
}