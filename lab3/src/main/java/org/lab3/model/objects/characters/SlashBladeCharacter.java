package org.lab3.model.objects.characters;

public interface SlashBladeCharacter {
    void changeDirection(int direction);
    void changeRunStatus(boolean isRun);
    void moveX(double currentFPS);
}
