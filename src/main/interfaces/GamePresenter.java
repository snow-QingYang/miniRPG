package main.interfaces;
import main.entities.Player;
public interface GamePresenter {
    void displayMessage(String message);
    void displayPlayerStatus(Player player);
    void displayStartMessage();
}