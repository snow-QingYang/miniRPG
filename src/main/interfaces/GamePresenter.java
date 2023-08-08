package main.interfaces;
import main.entities.DefaultPlayer;
public interface GamePresenter {
    void displayMessage(String message);
    void displayPlayerStatus(Player player);
    void displayStartMessage();

}