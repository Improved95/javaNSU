package org.lab3.model.objects.characters;

import org.lab3.model.objects.characters.movement.CharacterMovement;
import org.lab3.model.objects.characters.movement.CharacterParametersContext;
import org.lab3.slashBlade.FrameSize;

import java.util.Map;

public interface SlashBladeCharacter {
    void changeDirection(int direction);

    CharacterParametersContext getParametersContext();

    Map<String, CharacterMovement> getMovementList();

    void moveX(double currentFPS, FrameSize frameSize);
    void attack();
}
