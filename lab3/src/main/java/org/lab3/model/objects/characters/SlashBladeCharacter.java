package org.lab3.model.objects.characters;

public interface SlashBladeCharacter {
    void changeDirection(int direction);
    void changeMoveXStatus(boolean isRun);
    void moveX(double currentFPS);
}
