package org.lab3.model.objects.characters;

public interface SlashBladeCharacter {
    CharacterParametersContext getParametersContext();

    void moveX(double dx);

    void moveY(double dy);
}
