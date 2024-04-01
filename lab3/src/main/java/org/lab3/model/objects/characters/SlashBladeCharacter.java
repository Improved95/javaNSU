package org.lab3.model.objects.characters;

import org.lab3.controller.characterMovement.CharacterParametersContext;

public interface SlashBladeCharacter {
    void changeDirection(int direction);

    CharacterParametersContext getParametersContext();

    void moveX(double dx);

    void moveY(double dy);

    void attack();
}
