package interfaces;

public interface Monster {
    int calculateDamage();
    void takeDamage(int damage);
    boolean isDead();
    int getHealth();
}
